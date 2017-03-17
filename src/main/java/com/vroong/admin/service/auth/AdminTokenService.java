package com.vroong.admin.service.auth;

import com.vroong.common.service.auth.OauthTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdminTokenService extends OauthTokenService {

	@Override
	@Value(value = "${vroong.admin.api.baseUrl}")
	public void setBaseUrl(String value) {
		super.baseUrl = value;
	}

	@Override
	@Value(value = "${vroong.admin.api.authUrl}")
	public void setAuthUrl(String value) {
		super.authUrl = value;
	}

	@Override
	@Value(value = "${vroong.admin.api.userId}")
	public void setUserId(String value) {
		super.userId = value;
	}

	@Override
	@Value(value = "${vroong.admin.api.password}")
	public void setPassword(String value) {
		super.password = value;
	}

}
