package com.vroong.admin.api;

import com.vroong.admin.api.client.ApiClient;
import com.vroong.admin.api.client.api.PricingPolicyControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Created by reverof on 2017. 3. 17..
 */
@Component
@DependsOn({
    "adminApiClient"
})
public class AdminPricingPolicyApi extends PricingPolicyControllerApi {
    @Autowired
    public void setAdminApiClient(ApiClient adminApiClient) {
        setApiClient(adminApiClient);
    }
}
