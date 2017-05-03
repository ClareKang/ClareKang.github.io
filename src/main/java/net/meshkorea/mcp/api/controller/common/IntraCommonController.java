package net.meshkorea.mcp.api.controller.common;

import com.meshprime.api.client.model.Bank;
import com.meshprime.api.client.model.Regions;
import net.meshkorea.mcp.api.service.business.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jypark on 2017. 4. 6..
 */
@RestController
@RequestMapping(value = "/intra/v1")
public class IntraCommonController {

    @Autowired
    StoreService storeService;

    @GetMapping(value = "/stores/banks")
    public List<Bank> getBanks() throws Exception {
        return storeService.getBanks();
    }

    @GetMapping(value = "/regions/si_do")
    public List<Regions> listSido() throws Exception {
        return storeService.listSiDo();
    }

    @GetMapping(value = "/regions/si_gun_gu")
    public List<Regions> listSiGunGu(Integer parentCode, String siDo) throws Exception {
        return storeService.listSiGunGU(parentCode, siDo);
    }

    @GetMapping(value = "/regions/eup_myeon_dong_ri")
    public List<Regions> listEupMyeonDong(Integer parentCode, String siDo, String siGunGu, Boolean onlyAdminDong, Boolean onlyLegalDong) throws Exception {
        return storeService.listEupMyeonDongRi(parentCode, siDo, siGunGu, onlyAdminDong, onlyLegalDong);
    }
}
