package com.enterpret.feedback_ingest.repository;

import com.enterpret.feedback_ingest.model.feedback.Feedback;
import com.enterpret.feedback_ingest.model.feedback.FeedbackData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class FeedbackDataService {

    private List<Feedback> feedbacks;
    private Set<Integer> feedbackIds;

    public void addFeedback(Feedback feedback) {
        if (feedbacks == null) {
            feedbacks = new ArrayList<>();
            feedbackIds = new HashSet<>();
        }
        if(!feedbackIds.contains(feedback.getFeedbackMetadata().getId())){
            feedbackIds.add(feedback.getFeedbackMetadata().getId());
            feedbacks.add(feedback);
        }
    }

    public List<Feedback> getFeedbacks() {
        if (feedbacks == null) {
            feedbacks = new ArrayList<>();
        }
        return feedbacks;
    }


}
