package net.meshkorea.mcp.api.controller.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.BusinessClientVirtualBankAccount;
import com.meshprime.api.client.model.GetBusinessClientVirtualBankAccountsRequest;
import lombok.RequiredArgsConstructor;
import net.meshkorea.mcp.api.service.business.VirtualBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by clarekang on 2017. 9. 4..
 */
@RestController
@RequestMapping(value = "/v1/intra")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VirtualBankAccountController {

    private final VirtualBankAccountService virtualBankAccountService;

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
