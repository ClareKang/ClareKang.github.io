package net.meshkorea.mcp.api.service.fee;

import com.vroong.admin.api.AdminPricingPlanApi;
import com.vroong.admin.api.AdminPricingPolicyApi;
import com.vroong.admin.api.client.model.*;
import com.vroong.admin.service.auth.AdminTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungjae.hong on 2017. 3. 28..
 */
@Service
public class DistributionService {

    @Autowired
    AdminTokenService adminTokenService;

    @Autowired
    AdminPricingPlanApi adminPricingPlanApi;

    @Autowired
    AdminPricingPolicyApi adminPricingPolicyApi;

    public AdminPricingPlanListRes findPricingPlans(AdminPricingPlanListReq req) throws Exception {
        return adminPricingPlanApi.findPricingPlansUsingGET(adminTokenService.getAuthToken(), req);
    }

    public AddPricingPlanRes addPricingPlans(AddPricingPlanReq req) throws Exception {
        return adminPricingPlanApi.addPricingPlanUsingPOST(adminTokenService.getAuthToken(), req);
    }

    public AdminPricingPlanRes findPricingPlanById(int id) throws Exception {
        return adminPricingPlanApi.findPricingPlanByIdUsingGET(adminTokenService.getAuthToken(), (long) id);
    }

    public UpdatePricingPlanRes updatePricingPlan(UpdatePricingPlanReq req, int id) throws Exception {
        return adminPricingPlanApi.updatePricingPlanUsingPUT(adminTokenService.getAuthToken(), req, (long) id);
    }

    public AdminPricingPolicyListRes findPricingPolicies(AdminPricingPolicyListReq req) throws Exception {
        return adminPricingPolicyApi.findPricingPoliciesUsingGET(adminTokenService.getAuthToken(), req);
    }

    public AddPricingPolicyRes addPricingPolicy(AddPricingPolicyReq req) throws Exception {
        return adminPricingPolicyApi.addPricingPolicyUsingPOST(adminTokenService.getAuthToken(), req);
    }

    public AdminPricingPolicyRes findPricingPolicyById(int id) throws Exception {
        return adminPricingPolicyApi.findPricingPolicyByIdUsingGET(adminTokenService.getAuthToken(), (long) id);
    }

    public UpdatePricingPolicyRes updatePricingPolicy(UpdatePricingPolicyReq req, int id) throws Exception {
        return adminPricingPolicyApi.updatePricingPolicyUsingPUT(adminTokenService.getAuthToken(), req, (long) id);
    }
}
