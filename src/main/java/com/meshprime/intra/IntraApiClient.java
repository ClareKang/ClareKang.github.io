package com.meshprime.intra;

import com.meshprime.api.client.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by reverof on 2017. 3. 16..
 */
@Component
public class IntraApiClient extends ApiClient {

    @Override
    @Value(value = "${prime.intra.api.baseUrl}")
    public ApiClient setBasePath(String basePath) {
        super.setBasePath(basePath);
        return this;
    }

    @Override
    @Value(value = "${prime.intra.api.request.userAgent}")
    public ApiClient setUserAgent(String userAgent) {
        super.setUserAgent(userAgent);
        return this;
    }

}
