package net.meshkorea.mcp.api.controller;

import com.vroong.admin.api.client.model.PagedResourcesOfResourceOfAdminDto;
import net.meshkorea.mcp.api.service.VroongAdminClientTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by reverof on 2017. 3. 15..
 */
@Controller
@RequestMapping(value = "/admin")
public class VroongAdminApiTestController {

    @Autowired
    VroongAdminClientTestService vroongAdminClientTestService;

    @RequestMapping(value = "/getAdmins", method = RequestMethod.GET)
    public @ResponseBody PagedResourcesOfResourceOfAdminDto getAdmins() throws Exception {
        return vroongAdminClientTestService.getAdmins();
    }

}
