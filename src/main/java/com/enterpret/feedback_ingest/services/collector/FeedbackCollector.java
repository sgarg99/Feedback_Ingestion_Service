package com.enterpret.feedback_ingest.services.collector;

import com.enterpret.feedback_ingest.exceptions.ApiException;
import com.enterpret.feedback_ingest.model.feedback.Feedback;
import com.enterpret.feedback_ingest.model.tenant.TenantSourceConfig;
import com.enterpret.feedback_ingest.services.tranformer.FeedbackTransformer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface FeedbackCollector {

    List<Feedback> retrieveFeedback(String tenantId, TenantSourceConfig tenantSourceConfig, FeedbackTransformer feedbackTransformer) throws ApiException;
}
