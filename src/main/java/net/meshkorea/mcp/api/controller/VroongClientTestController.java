package net.meshkorea.mcp.api.controller;

import com.vroong.api.client.ApiException;
import net.meshkorea.mcp.api.service.VroongClientTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by reverof on 2017. 2. 28..
 */
@Controller
public class VroongClientTestController {

    @Autowired
    VroongClientTestService vroongClientTestService;

    @RequestMapping(value = "/systemStatus", method = RequestMethod.GET)
    public String getSystemStatus() throws ApiException {
        return vroongClientTestService.getSystemStatus();
    }

    @RequestMapping(value = "/getBanks", method = RequestMethod.GET)
    public String getBanks() throws ApiException {
        return vroongClientTestService.getBanks();
    }
}
