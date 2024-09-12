package com.enterpret.feedback_ingest.services;

import com.enterpret.feedback_ingest.exceptions.InvalidRequestException;
import com.enterpret.feedback_ingest.model.feedback.Feedback;
import com.enterpret.feedback_ingest.model.feedback.FeedbackType;
import com.enterpret.feedback_ingest.model.feedback.request.FeedbackRequest;
import com.enterpret.feedback_ingest.model.source.SourceType;
import com.enterpret.feedback_ingest.repository.FeedbackDataService;
import com.enterpret.feedback_ingest.services.factory.FeedbackTransformerFactory;
import com.enterpret.feedback_ingest.services.tranformer.FeedbackTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FeedbackService {

    @Autowired
    FeedbackDataService feedbackDataService;

    @Autowired
    FeedbackTransformerFactory feedbackTransformerFactory;

    @Autowired
    TenantService tenantService;

    public List<Feedback> getAllFeedbacks() {
        return feedbackDataService.getFeedbacks();
    }

    public void addFeedback(Feedback feedback) {
        feedbackDataService.addFeedback(feedback);
    }

    public void addFeedbacks(List<Feedback> feedbacks) {
        for (Feedback feedback : feedbacks) {
            feedbackDataService.addFeedback(feedback);
        }
    }

    public Feedback addFeedbackRequest(FeedbackRequest feedbackRequest) throws InvalidRequestException {
        SourceType sourceType = feedbackRequest.getSourceType();
        String tenantName = feedbackRequest.getTenantName();
        FeedbackType feedbackType = feedbackRequest.getFeedbackType();
        if(sourceType == null) {
            throw new InvalidRequestException("Give a valid source");
        }
        if(!tenantService.doesTenantExist(tenantName)) {
            throw new InvalidRequestException("Invalid tenant name");
        }
        String rawFeedback = feedbackRequest.getData();
        FeedbackTransformer feedbackTransformer = feedbackTransformerFactory.getFeedbackTransformer(sourceType);
        Feedback feedback = feedbackTransformer.transform(rawFeedback, tenantName);
        feedback.setFeedbackType(feedbackType);
        addFeedback(feedback);
        return feedback;
    }

    public List<Feedback> getAllFeedbackForATopic(String tenantUserName) {
        return feedbackDataService.getFeedbacks().stream().filter(feedback -> feedback.getTenantName().equals(tenantUserName)).toList();
    }
}
