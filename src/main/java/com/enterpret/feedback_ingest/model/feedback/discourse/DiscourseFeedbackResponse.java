package com.enterpret.feedback_ingest.model.feedback.discourse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscourseFeedbackResponse {
    int id;
    String name;
    String username;
    String avatar_template;
    Date created_at;
    int like_count;
    String blurb;
    int post_number;
    String topic_title_headline;
    String topic_id;
}
