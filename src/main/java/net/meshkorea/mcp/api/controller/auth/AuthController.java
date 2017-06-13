package net.meshkorea.mcp.api.controller.auth;

import net.meshkorea.mcp.api.domain.model.auth.UserDto;
import net.meshkorea.mcp.api.domain.model.auth.UserListRequest;
import net.meshkorea.mcp.api.domain.model.auth.UserListResponse;
import net.meshkorea.mcp.api.domain.model.common.ErrorDto;
import net.meshkorea.mcp.api.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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
            // authService.getUsers(userListRequest, pageable)
            new UserListResponse(new ErrorDto(HttpStatus.BAD_REQUEST, "잘못된 요청 입니다."))
        );
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(
            authService.getUser(userId)
        );
    }

    @PostMapping("/users")
    public UserDto addUser(@RequestBody UserDto user) {
        return authService.addUser(user);
    }

    public void getAuthorities(String token) {

    }

    public void getGroupList() {

    }

    public void getGroup() {

    }

}
