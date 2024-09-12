package com.enterpret.feedback_ingest.services;

import com.enterpret.feedback_ingest.exceptions.InvalidRequestException;
import com.enterpret.feedback_ingest.model.tenant.request.TenantConfigRequest;
import com.enterpret.feedback_ingest.model.tenant.request.TenantRequest;
import com.enterpret.feedback_ingest.model.tenant.Tenant;
import com.enterpret.feedback_ingest.model.tenant.TenantSourceConfig;
import com.enterpret.feedback_ingest.repository.TenantDataService;
import com.enterpret.feedback_ingest.services.factory.TenantConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantService {

    @Autowired
    TenantDataService tenantDataService;

    @Autowired
    TenantConfigFactory tenantConfigFactory;

    public Tenant addTenant(TenantRequest tenantRequest) throws InvalidRequestException {
        String tenantId = tenantRequest.getTenantId();
        String tenantName = tenantRequest.getTenantName();
        if(tenantId == null || tenantId.isEmpty()) {
            throw new InvalidRequestException("Give a valid tenant Id");
        }
        List<TenantConfigRequest> tenantConfigRequests = tenantRequest.getTenantConfigs();
        Tenant tenant = new Tenant();
        tenant.setTenantId(tenantId);
        tenant.setTenantName(tenantName);
        tenant.setTenantSourceConfigs(new ArrayList<>());
        if(tenantConfigRequests != null) {
            for(TenantConfigRequest tenantConfigRequest : tenantConfigRequests) {
                TenantSourceConfig tenantSourceConfig = tenantConfigFactory.getTenantConfig(tenantConfigRequest);
                tenant.getTenantSourceConfigs().add(tenantSourceConfig);
            }
        }
        tenantDataService.addTenant(tenant);
        return tenant;
    }

    public List<Tenant> getTenants() {
        return tenantDataService.getAllTenants();
    }

    public boolean doesTenantExist(String tenantName) {
         return getTenants().stream().anyMatch(t -> t.getTenantName().equals(tenantName));
    }
}
