package com.enterpret.feedback_ingest.model.tenant;

import com.enterpret.feedback_ingest.model.source.SourceType;

public class TwitterTenantSourceConfig extends TenantSourceConfig {

    private String searchString;

    public TwitterTenantSourceConfig(String topicId, String searchString) {
        super(SourceType.TWITTER, topicId);
        this.searchString = searchString;
    }


    public String getSearchString() {
        return searchString;
    }
}
