package net.meshkorea.mcp.api.controller.auth;

import net.meshkorea.mcp.api.domain.model.auth.GroupDto;
import net.meshkorea.mcp.api.domain.model.auth.GroupListRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by reverof on 2017. 6. 18..
 */
@RestController
@RequestMapping(value = "/v1/auth/groups")
public class GroupController {

    @GetMapping
    public void getGroups(GroupListRequest groupListRequest) {

    }

    @GetMapping("/{groupId}")
    public void getGroup(@PathVariable Long groupId) {

    }

    @PostMapping
    public void addGroup(@RequestBody GroupDto groupDto) {

    }
}
