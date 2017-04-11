package net.meshkorea.mcp.api.controller.common;

import com.meshprime.api.client.model.Bank;
import com.meshprime.api.client.model.Regions;
import net.meshkorea.mcp.api.service.PrimeIntraClientTestService;
import net.meshkorea.mcp.api.service.business.StoreService;
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

    @Autowired
    StoreService storeService;

    @RequestMapping(value = "/stores/banks", method = RequestMethod.GET)
    public @ResponseBody
    List<Bank> getBanks() throws Exception {
        return primeIntraClientTestService.getBanks();
    }

    @RequestMapping(value = "/regions/si_do", method = RequestMethod.GET)
    public @ResponseBody List<Regions> listSido() throws Exception {
        return storeService.listSiDo();
    }

    @RequestMapping(value = "/regions/si_gun_gu", method = RequestMethod.GET)
    public @ResponseBody List<Regions> listSiGunGu(Integer parentCode, String siDo) throws Exception {
        return storeService.listSiGunGU(parentCode, siDo);
    }

    @RequestMapping(value = "/regions/eup_myeon_dong_ri", method = RequestMethod.GET)
    public @ResponseBody List<Regions> listEupMyeonDong(Integer parentCode, String siDo, String siGunGu, Boolean onlyAdminDong, Boolean onlyLegalDong) throws Exception {
        return storeService.listEupMyeonDongRi(parentCode, siDo, siGunGu, onlyAdminDong, onlyLegalDong);
    }
}
