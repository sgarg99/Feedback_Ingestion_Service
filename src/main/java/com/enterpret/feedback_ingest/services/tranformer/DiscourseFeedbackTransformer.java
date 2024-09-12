package com.enterpret.feedback_ingest.services.tranformer;

import com.enterpret.feedback_ingest.model.feedback.Feedback;
import com.enterpret.feedback_ingest.model.feedback.FeedbackType;
import com.enterpret.feedback_ingest.model.feedback.discourse.DiscourseFeedbackData;
import com.enterpret.feedback_ingest.model.feedback.discourse.DiscourseFeedbackMetadata;
import com.enterpret.feedback_ingest.model.source.SourceType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class DiscourseFeedbackTransformer implements FeedbackTransformer {

    @Override
    public Feedback transform(String rawFeedback, String tenantName) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
             DiscourseFeedbackData discourseFeedbackData = objectMapper.readValue(rawFeedback, DiscourseFeedbackData.class);
             DiscourseFeedbackMetadata discourseFeedbackMetadata = objectMapper.readValue(rawFeedback, DiscourseFeedbackMetadata.class);
             Feedback feedback = Feedback.builder().tenantName(tenantName).sourceType(SourceType.DISCOURSE).feedbackType(FeedbackType.POST).feedbackData(discourseFeedbackData).feedbackMetadata(discourseFeedbackMetadata).build();
             return feedback;
         }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
