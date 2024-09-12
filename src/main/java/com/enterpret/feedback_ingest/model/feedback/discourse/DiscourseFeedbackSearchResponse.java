package com.enterpret.feedback_ingest.model.feedback.discourse;


import java.util.List;

public class DiscourseFeedbackSearchResponse {
    List<DiscourseFeedbackResponse> posts;

    public List<DiscourseFeedbackResponse> getPosts() {
        return posts;
    }
}
