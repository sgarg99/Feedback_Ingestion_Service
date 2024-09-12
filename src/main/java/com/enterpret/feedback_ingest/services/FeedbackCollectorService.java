package com.enterpret.feedback_ingest.services;

import com.enterpret.feedback_ingest.model.feedback.Feedback;
import com.enterpret.feedback_ingest.model.tenant.Tenant;
import com.enterpret.feedback_ingest.model.tenant.TenantSourceConfig;
import com.enterpret.feedback_ingest.services.collector.FeedbackCollector;
import com.enterpret.feedback_ingest.services.factory.FeedbackCollectorFactory;
import com.enterpret.feedback_ingest.services.factory.FeedbackTransformerFactory;
import com.enterpret.feedback_ingest.services.tranformer.FeedbackTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FeedbackCollectorService {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    TenantService tenantService;

    @Autowired
    FeedbackCollectorFactory feedbackCollectorFactory;

    @Autowired
    FeedbackTransformerFactory feedbackTransformerFactory;


    @Scheduled(fixedDelay = 60 * 1000 * 2)
    public void pullAndSaveFeedback()  {
        List<Tenant> tenants = tenantService.getTenants();
        for (Tenant tenant : tenants) {
            String tenantId = tenant.getTenantId();
            List<TenantSourceConfig> tenantSourceConfigs = tenant.getTenantSourceConfigs();
            for(TenantSourceConfig tenantSourceConfig : tenantSourceConfigs) {
                FeedbackCollector feedbackCollector = feedbackCollectorFactory.getFeedbackCollector(tenantSourceConfig.getSourceType());
                FeedbackTransformer feedbackTransformer = feedbackTransformerFactory.getFeedbackTransformer(tenantSourceConfig.getSourceType());
                try{
                    List<Feedback> feedbacks = feedbackCollector.retrieveFeedback(tenantId, tenantSourceConfig, feedbackTransformer);
                    feedbackService.addFeedbacks(feedbacks);
                }
                catch (Exception e) {
                    // log the exception here
                }
            }
        }
    }
}
