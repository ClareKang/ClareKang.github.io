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

    // 모든 상점의 가상계좌 조회 (폐점 제외)
    public List<StoreVirtualBankAccount> getAllStoreVirtualBankAccounts() throws ApiException {
        return intraVirtualBankAccount.getAllStoreVirtualBankAccounts(intraTokenService.getAuthToken());
    }

    // 특정 상점의 가상계좌 조회 (폐점 제외)
    public List<StoreVirtualBankAccount> getVirtualBankAccountsByStoreIds(GetStoreVirtualBankAccountsRequest req) throws ApiException {
        return intraVirtualBankAccount.getVirtualBankAccountsByStoreIds(intraTokenService.getAuthToken(), req);
    }

    // 모든 본사의 가상계좌 조회
    public List<BusinessClientVirtualBankAccount> getAllBusinessClientVirtualBankAccounts() throws ApiException {
        return intraVirtualBankAccount.getAllBusinessClientVirtualBankAccounts(intraTokenService.getAuthToken());
    }

    // 특정 본사의 가상계좌 조회
    public List<BusinessClientVirtualBankAccount> getVirtualBankAccountsByBusinessClientIds(GetBusinessClientVirtualBankAccountsRequest req) throws ApiException {
        return intraVirtualBankAccount.getVirtualBankAccountsByBusinessClientIds(intraTokenService.getAuthToken(), req);
    }

}
