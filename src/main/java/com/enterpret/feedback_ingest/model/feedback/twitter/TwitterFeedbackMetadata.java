package com.enterpret.feedback_ingest.model.feedback.twitter;

import com.enterpret.feedback_ingest.model.feedback.FeedbackMetadata;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TwitterFeedbackMetadata extends FeedbackMetadata {
    int id;
    String username;
    int likeCount;
    int retweetCount;
    int replyCount;
}
