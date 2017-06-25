package net.meshkorea.mcp.api.controller.common;

import net.meshkorea.mcp.api.domain.model.auth.CodeListResponse;
import net.meshkorea.mcp.api.service.common.McpCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/userTypes")
    public CodeListResponse getUserTypes() {
        return mcpCommonService.getUserTypes();
    }

    @GetMapping("/userSearchTypes")
    public CodeListResponse getUserSearchTypes() {
        return mcpCommonService.getUserSearchTypes();
    }

    @GetMapping("/groupTypes")
    public CodeListResponse getGroupTypes() {
        return mcpCommonService.getGroupTypes();
    }

    @GetMapping("/groupSearchTypes")
    public CodeListResponse getGroupSearchTypes() {
        return mcpCommonService.getGroupSearchTypes();
    }

}
