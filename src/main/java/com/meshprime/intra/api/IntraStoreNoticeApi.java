package com.meshprime.intra.api;

import com.meshprime.api.client.ApiClient;
import com.meshprime.api.client.api.StoreNoticesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Created by clare on 12/4/17.
 */

@Component
@DependsOn({
        "intraApiClient"
})
public class IntraStoreNoticeApi extends StoreNoticesApi {
    @Autowired
    public void setIntraApiClient(ApiClient intraApiClient) { setApiClient(intraApiClient); }
}
