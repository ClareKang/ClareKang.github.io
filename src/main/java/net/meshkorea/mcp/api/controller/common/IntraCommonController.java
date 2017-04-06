package net.meshkorea.mcp.api.controller.common;

import com.meshprime.api.client.model.Bank;
import net.meshkorea.mcp.api.service.PrimeIntraClientTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jypark on 2017. 4. 6..
 */
@Controller
@RequestMapping(value = "/intra/v1")
public class IntraCommonController {
    @Autowired
    PrimeIntraClientTestService primeIntraClientTestService;

    @RequestMapping(value = "/getBanks", method = RequestMethod.GET)
    public @ResponseBody
    List<Bank> getBanks() throws Exception {
        return primeIntraClientTestService.getBanks();
    }
}
