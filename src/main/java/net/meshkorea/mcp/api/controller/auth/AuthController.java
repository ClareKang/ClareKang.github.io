package net.meshkorea.mcp.api.controller.auth;

import net.meshkorea.mcp.api.domain.model.auth.UserListRequest;
import net.meshkorea.mcp.api.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by reverof on 2017. 5. 31..
 */
@RestController
@RequestMapping(value = "/v1/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(@RequestParam(required = false) UserListRequest userListRequest,
                                      @PageableDefault(sort = {"createDt"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(
            authService.getUsers(userListRequest, pageable)
        );
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(
            authService.getUser(userId)
        );
    }

    public void getAuthorities(String token) {

    }

    public void getGroupList() {

    }

    public void getGroup() {

    }

}
