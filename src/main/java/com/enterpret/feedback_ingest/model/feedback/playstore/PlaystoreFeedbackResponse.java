package com.enterpret.feedback_ingest.model.feedback.playstore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaystoreFeedbackResponse {
    int id;
    String username;
    Date created_at;
    int rating;
    String review;
    int likeCount;
    String appVersion;
}
