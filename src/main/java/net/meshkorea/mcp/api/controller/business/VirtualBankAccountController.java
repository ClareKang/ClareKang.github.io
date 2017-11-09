package net.meshkorea.mcp.api.controller.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import net.meshkorea.mcp.api.service.business.VirtualBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by clarekang on 2017. 9. 4..
 */
@RestController
@RequestMapping(value = "/v1/intra")
public class VirtualBankAccountController {

    @Autowired
    VirtualBankAccountService virtualBankAccountService;

    // 모든 상점의 가상계좌 조회 (폐점 제외)
    @GetMapping(path = "/virtual_bank_accounts/by_store/all")
    public List<StoreVirtualBankAccount> getVirtualBankAccounts() throws ApiException {
        return virtualBankAccountService.getAllStoreVirtualBankAccounts();
    }

    // 특정 상점의 가상계좌 조회 (폐점 제외)
    @PostMapping(path = "/virtual_bank_accounts/by_store")
    public List<StoreVirtualBankAccount> getVirtualBankAccountsByStoreIds(GetStoreVirtualBankAccountsRequest req) throws ApiException {
        return virtualBankAccountService.getVirtualBankAccountsByStoreIds(req);
    }

    // 모든 본사의 가상계좌 조회
    @GetMapping(path = "/virtual_bank_accounts/by_business_client/all")
    public List<BusinessClientVirtualBankAccount> getAllBusinessClientVirtualBankAccounts() throws ApiException {
        return virtualBankAccountService.getAllBusinessClientVirtualBankAccounts();
    }

    // 특정 본사의 가상계좌 조회
    @PostMapping(path = "/virtual_bank_accounts/by_business_client")
    public List<BusinessClientVirtualBankAccount> getVirtualBankAccountsByBusinessClientIds(GetBusinessClientVirtualBankAccountsRequest req) throws ApiException {
        return virtualBankAccountService.getVirtualBankAccountsByBusinessClientIds(req);
    }

}
