package com.enterpret.feedback_ingest.model.tenant.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TenantRequest {
    String tenantId;
    String tenantName;
    List<TenantConfigRequest> tenantConfigs;
}
