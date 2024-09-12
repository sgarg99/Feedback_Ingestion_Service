package com.enterpret.feedback_ingest.controller;

import com.enterpret.feedback_ingest.model.feedback.Feedback;
import com.enterpret.feedback_ingest.model.feedback.request.FeedbackRequest;
import com.enterpret.feedback_ingest.services.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(path = "/feedback/getAll", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.status(HttpStatus.OK).body(feedbacks);
    }

    @RequestMapping(path = "/feedback/add", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Object> addFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        try {
            Feedback feedback = feedbackService.addFeedbackRequest(feedbackRequest);
            return ResponseEntity.status(HttpStatus.OK).body(feedback);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(path = "/feedback/getAllForTenant", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<List<Feedback>> getAllFeedbackForATenant(@RequestParam String tenantName) {
        List<Feedback> feedbacks = feedbackService.getAllFeedbackForATopic(tenantName);
        return ResponseEntity.status(HttpStatus.OK).body(feedbacks);
    }

}
