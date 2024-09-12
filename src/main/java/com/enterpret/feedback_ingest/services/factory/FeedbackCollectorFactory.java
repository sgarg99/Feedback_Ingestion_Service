package com.enterpret.feedback_ingest.services.factory;

import com.enterpret.feedback_ingest.model.source.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.enterpret.feedback_ingest.services.collector.DiscourseFeedbackCollector;
import com.enterpret.feedback_ingest.services.collector.FeedbackCollector;



@Component
public class FeedbackCollectorFactory {

    @Autowired
    DiscourseFeedbackCollector discourseFeedbackCollector;

    public FeedbackCollector getFeedbackCollector(SourceType sourceType) {
        switch (sourceType) {
            case DISCOURSE -> {
                return discourseFeedbackCollector;
            }
        }
        return null;
    }
}
