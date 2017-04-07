package net.meshkorea.mcp.api.service.common;

import com.meshprime.api.client.model.Bank;
import com.meshprime.intra.api.IntraStoresApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jypark on 2017. 4. 6..
 */
public class IntraCommonService {
    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraStoresApi intraStoresApi;

    public List<Bank> getBanks() throws Exception {
        return intraStoresApi.listBanks(intraTokenService.getAuthToken());
    }
}
