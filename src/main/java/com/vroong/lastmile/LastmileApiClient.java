package com.vroong.lastmile;

import com.vroong.lastmile.api.client.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by reverof on 2017. 3. 16..
 */
@Component
public class LastmileApiClient extends ApiClient {

    @Override
    @Value(value = "${vroong.lastmile.api.baseUrl}")
    public ApiClient setBasePath(String basePath) {
        super.setBasePath(basePath);
        return this;
    }

    @Override
    @Value(value = "${vroong.lastmile.api.request.userAgent}")
    public ApiClient setUserAgent(String userAgent) {
        super.setUserAgent(userAgent);
        return this;
    }
}
