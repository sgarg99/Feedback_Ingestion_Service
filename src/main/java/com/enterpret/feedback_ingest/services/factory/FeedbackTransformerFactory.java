package com.enterpret.feedback_ingest.services.factory;

import com.enterpret.feedback_ingest.model.source.SourceType;
import com.enterpret.feedback_ingest.services.tranformer.DiscourseFeedbackTransformer;
import com.enterpret.feedback_ingest.services.tranformer.FeedbackTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedbackTransformerFactory {

    @Autowired
    DiscourseFeedbackTransformer discourseFeedbackTransformer;

    public FeedbackTransformer getFeedbackTransformer(SourceType sourceType) {
        switch (sourceType) {
            case DISCOURSE -> {
                return discourseFeedbackTransformer;
            }
        }
        return null;
    }
}
