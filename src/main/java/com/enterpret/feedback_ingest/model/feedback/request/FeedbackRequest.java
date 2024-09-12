package com.enterpret.feedback_ingest.model.feedback.request;

import com.enterpret.feedback_ingest.model.feedback.FeedbackType;
import com.enterpret.feedback_ingest.model.source.SourceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackRequest {
    String tenantName;
    SourceType sourceType;
    FeedbackType feedbackType;
    String data;
}
