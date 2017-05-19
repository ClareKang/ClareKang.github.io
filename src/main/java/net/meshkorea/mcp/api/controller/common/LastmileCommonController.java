package net.meshkorea.mcp.api.controller.common;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.ManagerCheckUsernameReq;
import com.vroong.lastmile.api.client.model.ManagerCheckUsernameRes;
import com.vroong.lastmile.api.client.model.ManagerGetBanksRes;
import net.meshkorea.mcp.api.service.common.LastmileCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping(value = "/v1/lastmile")
public class LastmileCommonController {

    @Autowired
    LastmileCommonService lastmileCommonService;

    @PostMapping(value = "/checkUsername")
    public ManagerCheckUsernameRes checkUsername(ManagerCheckUsernameReq req) throws ApiException {
        return lastmileCommonService.checkUsername(req);
    }

    @GetMapping(value = "/getBanks")
    public ManagerGetBanksRes getBanks() throws ApiException {
        return lastmileCommonService.getBanks();
    }
}
