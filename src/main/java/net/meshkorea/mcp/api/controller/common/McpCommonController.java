package net.meshkorea.mcp.api.controller.common;

import net.meshkorea.mcp.api.domain.model.auth.UserTypeListResponse;
import net.meshkorea.mcp.api.service.common.McpCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by reverof on 2017. 6. 14..
 */
@RestController
@RequestMapping(value = "/v1/common")
public class McpCommonController {

    @Autowired
    private McpCommonService mcpCommonService;

    @GetMapping("/userTypes")
    public UserTypeListResponse getUserTypes() {
        return mcpCommonService.getUserTypes();
    }
}
