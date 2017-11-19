package com.vroong.lastmile.api;

import com.vroong.lastmile.api.client.ApiClient;
import com.vroong.lastmile.api.client.api.MonitoringServiceControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({
    "lastmileApiClient"
})
public class LastmileMonitoringApi extends MonitoringServiceControllerApi {
    @Autowired
    public void setLastmileApiClient(ApiClient lastmileApiClient) {
        setApiClient(lastmileApiClient);
    }
}
