package com.enterpret.feedback_ingest.model.tenant;

import com.enterpret.feedback_ingest.model.source.SourceType;

public class DiscourceTenantSourceConfig extends TenantSourceConfig {

    private String searchString;

    public DiscourceTenantSourceConfig(String topicId, String searchString) {
        super(SourceType.DISCOURSE, topicId);
        this.searchString = searchString;
    }


    public String getSearchString() {
        return searchString;
    }

}
