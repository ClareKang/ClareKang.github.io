package net.meshkorea.mcp.api.controller.auth;

import net.meshkorea.mcp.api.domain.model.auth.*;
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
    public GroupResponse getGroup(@PathVariable Long groupId) {
        return groupService.getGroup(groupId);
    }

    @GetMapping("/{groupId}/authorities")
    public AuthorityListResponse getAuthoritiesByGroup(@PathVariable Long groupId) {
        return groupService.getAuthoritiesByGroup(groupId);
    }

    @PostMapping
    public void addGroup(@RequestBody GroupRequest groupRequest) {
        System.out.println(groupRequest);
        groupService.addGroup(groupRequest);
    }

    @PostMapping("/{groupId}/authorities")
    public void updateGroupAuthorities() {

    }
}
