package net.meshkorea.mcp.api.controller.auth;

import net.meshkorea.mcp.api.domain.model.auth.*;
import net.meshkorea.mcp.api.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by reverof on 2017-06-13.
 */
@RestController
@RequestMapping(value = "/v1/auth/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public UserListResponse getUsers(@RequestParam(required = false) UserListRequest userListRequest) {
        return userService.getUsers(userListRequest);
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public UserResponse addUser(@RequestBody UserDto user) {
        return userService.addUser(user);
    }
}
