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

    @GetMapping(path = "/virtual_bank_accounts/all")
    public List<VirtualBankAccount> getVirtualBankAccounts() throws ApiException {
        return virtualBankAccountService.getVirtualBankAccounts();
    }

    @PostMapping(path = "/virtual_bank_accounts")
    public List<VirtualBankAccount> getStoreVirtualBankAccounts(GetStoreVirtualBankAccountsRequest req) throws ApiException {
        return virtualBankAccountService.getStoreVirtualBankAccounts(req);
    }
}
