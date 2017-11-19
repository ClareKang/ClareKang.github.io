package com.meshprime.intra.api;

import com.meshprime.api.client.ApiClient;
import com.meshprime.api.client.api.SubscriptionsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({
    "intraAccountingApiClient"
})
public class IntraAccountingSubscriptionApi extends SubscriptionsApi {
    @Autowired
    public void setIntraAccountingApiClient(ApiClient intraAccountingApiClient) {
        setApiClient(intraAccountingApiClient);
    }
}
