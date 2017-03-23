package com.meshprime.intra.api;

import com.meshprime.api.client.ApiClient;
import com.meshprime.api.client.api.WarehousesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Created by reverof on 2017. 3. 16..
 */
@Component
@DependsOn({
        "intraApiClient"
})
public class IntraWarehousesApi extends WarehousesApi {
    @Autowired
    public void setIntraApiClient(ApiClient intraApiClient) {
        setApiClient(intraApiClient);
    }
}
