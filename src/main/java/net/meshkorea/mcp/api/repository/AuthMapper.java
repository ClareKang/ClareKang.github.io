package net.meshkorea.mcp.api.repository;

import net.meshkorea.mcp.api.config.data.AuthDbConfig;
import net.meshkorea.mcp.api.config.data.VroongDbConfig;

import java.util.Map;

@AuthDbConfig.AuthData
public interface AuthMapper {

	Map<String, Object> getAuthList(String user_id);

}
