package net.meshkorea.mcp.api.service;

import com.meshprime.api.client.model.BankList;
import com.meshprime.intra.api.IntraStoresApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by reverof on 2017. 2. 28..
 */
@Service
public class PrimeIntraClientTestService {

    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraStoresApi intraStoresApi;

    public BankList getBanks() throws Exception {
        return intraStoresApi.listBanks(intraTokenService.getAuthToken());
    }
}
