package com.meshprime.intra.api;

import com.meshprime.api.client.ApiClient;
import com.meshprime.api.client.api.PointApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({
    "intraAccountingApiClient"
})
public class IntraAccountingPointApi extends PointApi {
    @Autowired
    public void setIntraAccountingApiClient(ApiClient intraAccountingApiClient) {
        setApiClient(intraAccountingApiClient);
    }
}
