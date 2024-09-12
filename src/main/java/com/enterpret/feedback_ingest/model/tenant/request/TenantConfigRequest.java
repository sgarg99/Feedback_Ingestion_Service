package com.enterpret.feedback_ingest.model.tenant.request;

import com.enterpret.feedback_ingest.model.source.SourceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TenantConfigRequest {
    String topicId;
    SourceType sourceType;
    Map<String, String> additionalInfo;
}
