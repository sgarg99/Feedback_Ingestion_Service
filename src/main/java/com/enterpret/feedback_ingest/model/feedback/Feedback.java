package com.enterpret.feedback_ingest.model.feedback;

import com.enterpret.feedback_ingest.model.source.SourceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback {

    String tenantName;
    SourceType sourceType;
    FeedbackData feedbackData;
    FeedbackMetadata feedbackMetadata;
    FeedbackType feedbackType;

}
