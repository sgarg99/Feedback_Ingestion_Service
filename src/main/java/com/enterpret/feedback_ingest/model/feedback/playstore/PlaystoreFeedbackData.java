package com.enterpret.feedback_ingest.model.feedback.playstore;

import com.enterpret.feedback_ingest.model.feedback.FeedbackData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaystoreFeedbackData extends FeedbackData {
    int rating;
    String review;
}
