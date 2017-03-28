package com.vroong.admin;

import com.vroong.admin.api.client.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by reverof on 2017. 3. 16..
 */
@Component
public class AdminApiClient extends ApiClient {

    @Override
    @Value(value = "${vroong.admin.api.baseUrl}")
    public ApiClient setBasePath(String basePath) {
        super.setBasePath(basePath);
        return this;
    }

    @Override
    @Value(value = "${vroong.admin.api.request.userAgent}")
    public ApiClient setUserAgent(String userAgent) {
        super.setUserAgent(userAgent);
        return this;
    }
}
