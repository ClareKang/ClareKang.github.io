package net.meshkorea.mcp.api.controller.common;

import com.meshprime.api.client.model.Bank;
import com.meshprime.api.client.model.Regions;
import net.meshkorea.mcp.api.service.common.IntraCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jypark on 2017. 4. 6..
 */
@RestController
@RequestMapping(value = "/v1/intra")
public class IntraCommonController {

    @Autowired
    IntraCommonService intraCommonService;

    @GetMapping("/banks")
    public List<Bank> getBanks() throws Exception {
        return intraCommonService.getBanks();
    }

}
