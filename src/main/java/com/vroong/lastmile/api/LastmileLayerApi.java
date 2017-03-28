package com.vroong.lastmile.api;

import com.vroong.lastmile.api.client.ApiClient;
import com.vroong.lastmile.api.client.api.LayercontrollerimplApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Created by reverof on 2017. 3. 17..
 */
@Component
@DependsOn({
        "lastmileApiClient"
})
public class LastmileLayerApi extends LayercontrollerimplApi {
    @Autowired
    public void setLastmileApiClient(ApiClient lastmileApiClient) {
        setApiClient(lastmileApiClient);
    }
}
