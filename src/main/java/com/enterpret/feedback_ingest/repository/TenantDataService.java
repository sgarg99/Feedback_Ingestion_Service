package com.enterpret.feedback_ingest.repository;

import com.enterpret.feedback_ingest.model.tenant.Tenant;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TenantDataService {

    Map<String, Tenant> tenants;

    public void addTenant(Tenant tenant) {
        if(tenants == null) {
            tenants = new HashMap<>();
        }
        tenants.put(tenant.getTenantId(), tenant);
    }
    public List<Tenant> getAllTenants() {
        return tenants != null ? Collections.unmodifiableList(new ArrayList<>(tenants.values())) : new ArrayList<>();
    }
}
