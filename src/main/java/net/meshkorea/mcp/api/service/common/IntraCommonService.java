package net.meshkorea.mcp.api.service.common;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.Bank;
import com.meshprime.api.client.model.Latlng;
import com.meshprime.api.client.model.Regions;
import com.meshprime.intra.api.IntraRegionsApi;
import com.meshprime.intra.api.IntraStoresApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jypark on 2017. 4. 6..
 */
@Service
public class IntraCommonService {

    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraStoresApi intraStoresApi;

    @Autowired
    IntraRegionsApi intraRegionsApi;

    public List<Bank> getBanks() throws Exception {
        return intraStoresApi.listBanks(intraTokenService.getAuthToken());
    }

    public List<Regions> listSiDo() throws Exception {
        return intraRegionsApi.listRegionsSiDo(intraTokenService.getAuthToken());
    }

    public List<Regions> listSiGunGU(Integer parentCode, String siDo) throws Exception {
        return intraRegionsApi.listSiGunGuByCode(intraTokenService.getAuthToken(), parentCode, siDo);
    }

    public List<Regions> listEupMyeonDongRi(Integer parentCode, String siDo, String siGunGu, Boolean onlyAdminDong, Boolean onlyLegalDong) throws Exception {
        return intraRegionsApi.listEupMyeonDongByCode(intraTokenService.getAuthToken(), parentCode, siDo, siGunGu, onlyAdminDong, onlyLegalDong);
    }

    public Latlng getGeocode(String address) throws ApiException {
        return intraRegionsApi.getGeocode(intraTokenService.getAuthToken(), address);
    }

}
