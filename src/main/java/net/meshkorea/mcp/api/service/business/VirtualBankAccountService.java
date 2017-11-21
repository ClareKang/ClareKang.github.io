package net.meshkorea.mcp.api.service.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.BusinessClientVirtualBankAccount;
import com.meshprime.api.client.model.GetBusinessClientVirtualBankAccountsRequest;
import com.meshprime.api.client.model.GetStoreVirtualBankAccountsRequest;
import com.meshprime.api.client.model.StoreVirtualBankAccount;
import com.meshprime.common.constant.IntraApiTypeEnum;
import com.meshprime.intra.api.IntraVirtualBankAccountApiFactory;
import com.meshprime.intra.service.auth.IntraTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by clarekang on 2017. 9. 4..
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VirtualBankAccountService {

    private final IntraTokenService intraTokenService;

    private final IntraVirtualBankAccountApiFactory intraVirtualBankAccountApiFactory;

    // 모든 상점의 가상계좌 조회 (폐점 제외)
    public List<StoreVirtualBankAccount> getAllStoreVirtualBankAccounts() throws ApiException {
        return intraVirtualBankAccountApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getAllStoreVirtualBankAccounts(intraTokenService.getAuthToken());
    }

    // 특정 상점의 가상계좌 조회 (폐점 제외)
    public List<StoreVirtualBankAccount> getVirtualBankAccountsByStoreIds(GetStoreVirtualBankAccountsRequest req) throws ApiException {
        return intraVirtualBankAccountApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getVirtualBankAccountsByStoreIds(intraTokenService.getAuthToken(), req);
    }

    // 모든 본사의 가상계좌 조회
    public List<BusinessClientVirtualBankAccount> getAllBusinessClientVirtualBankAccounts() throws ApiException {
        return intraVirtualBankAccountApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getAllBusinessClientVirtualBankAccounts(intraTokenService.getAuthToken());
    }

    // 특정 본사의 가상계좌 조회
    public List<BusinessClientVirtualBankAccount> getVirtualBankAccountsByBusinessClientIds(GetBusinessClientVirtualBankAccountsRequest req) throws ApiException {
        return intraVirtualBankAccountApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getVirtualBankAccountsByBusinessClientIds(intraTokenService.getAuthToken(), req);
    }

}
