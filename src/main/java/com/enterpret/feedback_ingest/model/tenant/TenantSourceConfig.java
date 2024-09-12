package com.enterpret.feedback_ingest.model.tenant;

import com.enterpret.feedback_ingest.model.source.SourceType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TenantSourceConfig {
    SourceType sourceType;
    String topicId;
}
