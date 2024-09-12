package com.enterpret.feedback_ingest.model.tenant;

import com.enterpret.feedback_ingest.model.source.SourceType;

public class PlaystoreTenantSourceConfig extends TenantSourceConfig {

    private String appStore;

    public PlaystoreTenantSourceConfig(String topicId, String appStore) {
        super( SourceType.PLAYSTORE, topicId);
        this.appStore = appStore;
    }

    public String getAppStore() {
        return appStore;
    }
}
