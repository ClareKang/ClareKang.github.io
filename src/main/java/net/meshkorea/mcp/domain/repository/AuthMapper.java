package net.meshkorea.mcp.domain.repository;

import net.meshkorea.mcp.api.config.data.AuthDbConfig;

import java.util.Map;

@AuthDbConfig.AuthData
public interface AuthMapper {

	Map<String, Object> getAuthList(String user_id);

}
