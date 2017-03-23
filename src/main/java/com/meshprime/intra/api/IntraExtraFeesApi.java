package com.meshprime.intra.api;

import com.meshprime.api.client.ApiClient;
import com.meshprime.api.client.api.ExtraFeesApi;
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
public class IntraExtraFeesApi extends ExtraFeesApi {
    @Autowired
    public void setIntraApiClient(ApiClient intraApiClient) {
        setApiClient(intraApiClient);
    }
}
