package net.meshkorea.mcp.api.controller.auth;

import net.meshkorea.mcp.api.domain.model.auth.GroupDto;
import net.meshkorea.mcp.api.domain.model.auth.GroupListRequest;
import net.meshkorea.mcp.api.domain.model.auth.GroupListResponse;
import net.meshkorea.mcp.api.service.auth.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by reverof on 2017. 6. 18..
 */
@RestController
@RequestMapping(value = "/v1/auth/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public GroupListResponse getGroups(@RequestParam(required = false) GroupListRequest groupListRequest) {
        return groupService.getGroups(groupListRequest);
    }

    @GetMapping("/{groupId}")
    public GroupDto getGroup(@PathVariable Long groupId) {
        return groupService.getGroup(groupId);
    }

    @PostMapping
    public void addGroup(@RequestBody GroupDto groupDto) {

    }
}
