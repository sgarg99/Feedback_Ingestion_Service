package com.enterpret.feedback_ingest.model.tenant;

import lombok.Data;

import java.util.List;

@Data
public class Tenant {

    String tenantName;
    String tenantId;
    List<TenantSourceConfig> tenantSourceConfigs;

}
