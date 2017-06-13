package net.meshkorea.mcp.api.controller.auth;

import net.meshkorea.mcp.api.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by reverof on 2017. 5. 31..
 */
@RestController
@RequestMapping(value = "/v1/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    public void getAuthorities(String token) {

    }

    public void getGroupList() {

    }

    public void getGroup() {

    }

}
