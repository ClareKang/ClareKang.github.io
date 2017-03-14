package net.meshkorea.mcp.api.controller.common;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@Controller
public class CommonController {

    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    public @ResponseBody
    ManagerCheckUsernameRes checkUsername(ManagerCheckUsernameReq req) throws ApiException {
        return new ManagerCheckUsernameRes();
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public @ResponseBody
    ManagerChangePasswordRes changePassword(ManagerChangePasswordReq req) throws ApiException {
        return new ManagerChangePasswordRes();
    }

    @RequestMapping(value = "/getBanks", method = RequestMethod.GET)
    public @ResponseBody
    ManagerGetBanksRes getBanks() throws ApiException {
        return new ManagerGetBanksRes();
    }
}
