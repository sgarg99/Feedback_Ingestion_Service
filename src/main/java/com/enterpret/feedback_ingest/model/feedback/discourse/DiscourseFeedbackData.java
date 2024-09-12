package com.enterpret.feedback_ingest.model.feedback.discourse;

import com.enterpret.feedback_ingest.model.feedback.FeedbackData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscourseFeedbackData extends FeedbackData {
    String blurb;
}

