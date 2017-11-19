package com.meshprime.intra;

import com.meshprime.api.client.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IntraAccountingApiClient extends ApiClient {

    @Override
    @Value(value = "${prime.accounting.api.baseUrl}")
    public ApiClient setBasePath(String basePath) {
        super.setBasePath(basePath);
        return this;
    }

    @Override
    @Value(value = "${prime.accounting.api.request.userAgent}")
    public ApiClient setUserAgent(String userAgent) {
        super.setUserAgent(userAgent);
        return this;
    }

}
