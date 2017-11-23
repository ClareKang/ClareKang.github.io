package com.meshprime.intra.api;

import com.meshprime.api.client.ApiClient;
import com.meshprime.api.client.api.VirtualBankAccountsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Created by clarekang on 2017. 9. 4..
 */
@Component
@DependsOn({
        "intraApiClient"
})
public class IntraVirtualBankAccountApi extends VirtualBankAccountsApi {
    @Autowired
    public void setIntraApiClient(ApiClient intraApiClient) {
        setApiClient(intraApiClient);
    }
}
