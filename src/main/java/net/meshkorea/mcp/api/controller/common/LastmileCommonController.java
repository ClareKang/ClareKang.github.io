package net.meshkorea.mcp.api.controller.common;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.common.LastmileCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@Controller
@RequestMapping(value = "/lastmile")
public class LastmileCommonController {

    @Autowired
    LastmileCommonService lastmileCommonService;

    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    public @ResponseBody
    ManagerCheckUsernameRes checkUsername(ManagerCheckUsernameReq req) throws ApiException {
        return lastmileCommonService.checkUsername(req);
    }

    @RequestMapping(value = "/getBanks", method = RequestMethod.GET)
    public @ResponseBody
    ManagerGetBanksRes getBanks() throws ApiException {
        return lastmileCommonService.getBanks();
    }
}
