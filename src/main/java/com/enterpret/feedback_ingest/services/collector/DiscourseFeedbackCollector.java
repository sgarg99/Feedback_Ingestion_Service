package com.enterpret.feedback_ingest.services.collector;

import com.enterpret.feedback_ingest.exceptions.ApiException;
import com.enterpret.feedback_ingest.model.feedback.Feedback;
import com.enterpret.feedback_ingest.model.feedback.discourse.DiscourseFeedbackResponse;
import com.enterpret.feedback_ingest.model.feedback.discourse.DiscourseFeedbackSearchResponse;
import com.enterpret.feedback_ingest.model.tenant.DiscourceTenantSourceConfig;
import com.enterpret.feedback_ingest.model.tenant.TenantSourceConfig;
import com.enterpret.feedback_ingest.services.tranformer.FeedbackTransformer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DiscourseFeedbackCollector implements FeedbackCollector {

    private final String url = "https://meta.discourse.org/search.json";


    @Override
    public List<Feedback> retrieveFeedback(String tenantName, TenantSourceConfig tenantSourceConfig, FeedbackTransformer transformer) throws ApiException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        DiscourceTenantSourceConfig discourceTenantSourceConfig = (DiscourceTenantSourceConfig) tenantSourceConfig;
        String searchString = discourceTenantSourceConfig.getSearchString();
        int pageNumber = 1;
        String datePattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        String curDate = simpleDateFormat.format(new Date());
        long millisInADay = 1000 * 60 * 60 * 24;
        String prevDate = simpleDateFormat.format(new Date(new Date().getTime() - millisInADay));

        List<Feedback> discourseFeedbackList = new ArrayList<>();
        try{
            while (true) {
                String command = "curl --location --request GET " + url + "?page=" + pageNumber + "&q=after%3A" + prevDate + "+before%3A" + curDate;
                Process process = Runtime.getRuntime().exec(command);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                String response = "";
                while ((line = reader.readLine()) != null) {
                    response = response.concat(line);
                }
                DiscourseFeedbackSearchResponse discourseFeedbackSearchResponse = objectMapper.readValue(response, DiscourseFeedbackSearchResponse.class);
                if (discourseFeedbackSearchResponse.getPosts().isEmpty())
                    break;
                for (DiscourseFeedbackResponse discourseFeedbackRequest : discourseFeedbackSearchResponse.getPosts()) {
                    String discourseFeedbackString = objectMapper.writeValueAsString(discourseFeedbackRequest);
                    discourseFeedbackList.add(transformer.transform(discourseFeedbackString, tenantName));
                }
                pageNumber++;
            }
        }
       catch (IOException e){
           throw new ApiException(e, "Error in fetching feedback from Discourse");
       }
        return discourseFeedbackList;
    }

}
