package com.enterpret.feedback_ingest.model.feedback.twitter;

import java.util.Date;

public class TwitterFeedbackResponse {
    int id;
    String username;
    String tweet;
    Date createdAt;
    int likeCount;
    int retweetCount;
    int replyCount;
}
