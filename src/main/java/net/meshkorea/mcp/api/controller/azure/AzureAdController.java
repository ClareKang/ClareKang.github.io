package net.meshkorea.mcp.api.controller.azure;

import net.meshkorea.mcp.api.domain.model.azure.AdUserResponse;
import net.meshkorea.mcp.api.domain.model.azure.AdUserSimple;
import net.meshkorea.mcp.api.service.azure.AzureAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yjhan on 2017. 6. 24..
 */
@RestController
@RequestMapping(value = "/v1/auth/azureAd")
public class AzureAdController {

    @Autowired
    private AzureAdService azureAdService;

    @GetMapping("/users")
    public AdUserResponse getUsers() throws Exception {
        List<AdUserSimple> result = azureAdService.getUsers();
        return new AdUserResponse(result);
    }
}
