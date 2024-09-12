package com.enterpret.feedback_ingest.services.collector;

import com.enterpret.feedback_ingest.exceptions.ApiException;
import com.enterpret.feedback_ingest.model.feedback.Feedback;
import com.enterpret.feedback_ingest.model.tenant.TenantSourceConfig;
import com.enterpret.feedback_ingest.services.tranformer.FeedbackTransformer;

import java.util.List;

public class TwitterFeedbackCollector implements FeedbackCollector {
    @Override
    public List<Feedback> retrieveFeedback(String tenantId, TenantSourceConfig tenantSourceConfig, FeedbackTransformer feedbackTransformer) throws ApiException {
        // implement for twitter
        return List.of();
    }
}
