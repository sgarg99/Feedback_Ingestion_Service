package com.enterpret.feedback_ingest.services.factory;

import com.enterpret.feedback_ingest.model.tenant.request.TenantConfigRequest;
import com.enterpret.feedback_ingest.model.tenant.DiscourceTenantSourceConfig;
import com.enterpret.feedback_ingest.model.tenant.PlaystoreTenantSourceConfig;
import com.enterpret.feedback_ingest.model.tenant.TenantSourceConfig;
import com.enterpret.feedback_ingest.model.tenant.TwitterTenantSourceConfig;
import org.springframework.stereotype.Component;

@Component
public class TenantConfigFactory {

    public TenantSourceConfig getTenantConfig(TenantConfigRequest tenantConfigRequest) {
        switch (tenantConfigRequest.getSourceType()) {
            case DISCOURSE -> {
                 String searchString  = tenantConfigRequest.getAdditionalInfo().get("searchString");
                 return new DiscourceTenantSourceConfig(tenantConfigRequest.getTopicId(), searchString);
            }
            case PLAYSTORE -> {
                 String appVersion = tenantConfigRequest.getAdditionalInfo().get("appVersion");
                 return new PlaystoreTenantSourceConfig(tenantConfigRequest.getTopicId(), appVersion);
            }
            case TWITTER -> {
                 String searchString  = tenantConfigRequest.getAdditionalInfo().get("searchString");
                 return new TwitterTenantSourceConfig(tenantConfigRequest.getTopicId(), searchString);
            }
        }
        return null;
    }
}
