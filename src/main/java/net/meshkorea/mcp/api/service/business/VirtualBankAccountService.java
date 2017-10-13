package net.meshkorea.mcp.api.service.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import com.meshprime.intra.api.*;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by clarekang on 2017. 9. 4..
 */
@Service
public class VirtualBankAccountService {

    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraVirtualBankAccount intraVirtualBankAccount;

    public List<VirtualBankAccount> getVirtualBankAccounts() throws ApiException {
        return intraVirtualBankAccount.getVirtualBankAccounts(intraTokenService.getAuthToken());
    }

    public List<VirtualBankAccount> getStoreVirtualBankAccounts(GetStoreVirtualBankAccountsRequest req) throws ApiException {
        return intraVirtualBankAccount.getStoreVirtualBankAccounts(intraTokenService.getAuthToken(), req);
    }
}
