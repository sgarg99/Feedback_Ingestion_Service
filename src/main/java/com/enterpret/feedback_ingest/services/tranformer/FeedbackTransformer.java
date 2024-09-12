package com.enterpret.feedback_ingest.services.tranformer;

import com.enterpret.feedback_ingest.model.feedback.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackTransformer {

    public Feedback transform(String rawFeedback, String tenantName);

}
