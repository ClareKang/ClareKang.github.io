package com.meshprime.intra.service.auth;

import com.meshprime.api.client.api.AuthApi;
import com.meshprime.common.service.auth.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * Created by reverof on 2017. 3. 16..
 */
@Service
@DependsOn({
        "intraAuthApi"
})
public class IntraTokenService extends JwtTokenService {

    private AuthApi authApi;

    @Autowired
    public void setAuthApi(AuthApi authApi) {
        this.authApi = authApi;
    }

    public AuthApi getAuthApi() {
        return this.authApi;
    }

    @Override
    @Value(value = "${prime.intra.api.userId}")
    public void setUserId(String value) {
        super.setUserId(value);
    }

    @Override
    @Value(value = "${prime.intra.api.password}")
    public void setPassword(String value) {
        super.setPassword(value);
    }

}
