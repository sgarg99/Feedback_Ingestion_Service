package com.enterpret.feedback_ingest.model.feedback.discourse;

import com.enterpret.feedback_ingest.model.feedback.FeedbackMetadata;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscourseFeedbackMetadata extends FeedbackMetadata {
    String name;
    String username;
    String avatar_template;
    int like_count;
    int post_number;
    String topic_title_headline;
    String topic_id;
}
