package com.meshprime.intra.api;

import com.meshprime.api.client.ApiClient;
import com.meshprime.api.client.api.PointApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Created by clare on 9/13/17.
 */
@Component
@DependsOn({
        "intraApiClient"
})
public class IntraPointApi extends PointApi {
    @Autowired
    public void setIntraApiClient(ApiClient intraApiClient) {
        setApiClient(intraApiClient);
    }
}
