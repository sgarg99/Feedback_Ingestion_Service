package com.enterpret.feedback_ingest.controller;

import com.enterpret.feedback_ingest.model.tenant.request.TenantRequest;
import com.enterpret.feedback_ingest.model.tenant.Tenant;
import com.enterpret.feedback_ingest.services.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @RequestMapping(path = "/tenant/add", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Object> addTenant(@RequestBody TenantRequest tenantRequest) {
        try {
            Tenant tenant = tenantService.addTenant(tenantRequest);
            return ResponseEntity.status(HttpStatus.OK).body(tenant);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}