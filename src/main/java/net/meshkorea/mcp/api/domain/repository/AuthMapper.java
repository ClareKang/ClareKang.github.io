package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.platform.core.web.config.data.AuthDbConfig;

import java.util.Map;

@AuthDbConfig.AuthData
public interface AuthMapper {

    Map<String, Object> getAuthList(String user_id);

}
