package net.meshkorea.mcp.api.controller.auth;

import net.meshkorea.mcp.api.domain.model.auth.AuthorityDto;
import net.meshkorea.mcp.api.service.auth.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by reverof on 2017. 5. 31..
 */
@RestController
@RequestMapping(value = "/v1/auth/authorities")
public class AuthorityController {

    @Autowired
    AuthoritiesService authoritiesService;

    @GetMapping
    public List<AuthorityDto> getAllAuthorities() {
        return authoritiesService.getAllAuthorities();
    }

    public void getGroupList() {

    }

    public void getGroup() {

    }

}
