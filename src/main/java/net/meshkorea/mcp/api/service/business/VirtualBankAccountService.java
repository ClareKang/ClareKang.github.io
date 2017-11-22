package net.meshkorea.mcp.api.service.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.BusinessClientVirtualBankAccount;
import com.meshprime.api.client.model.GetBusinessClientVirtualBankAccountsRequest;
import com.meshprime.common.constant.IntraApiTypeEnum;
import com.meshprime.intra.api.IntraVirtualBankAccountApiFactory;
import com.meshprime.intra.service.auth.IntraTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by clarekang on 2017. 9. 4..
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VirtualBankAccountService {

    private final IntraTokenService intraTokenService;

    private final IntraVirtualBankAccountApiFactory intraVirtualBankAccountApiFactory;

    // 모든 본사의 가상계좌 조회
    public List<BusinessClientVirtualBankAccount> getAllBusinessClientVirtualBankAccounts() throws ApiException {
        return intraVirtualBankAccountApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getAllBusinessClientVirtualBankAccounts(intraTokenService.getAuthToken());
    }

    // 특정 본사의 가상계좌 조회
    public List<BusinessClientVirtualBankAccount> getVirtualBankAccountsByBusinessClientIds(GetBusinessClientVirtualBankAccountsRequest req) throws ApiException {
        return intraVirtualBankAccountApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getVirtualBankAccountsByBusinessClientIds(intraTokenService.getAuthToken(), req);
    }

    // 특정 본사의 가상계좌 조회 (엑셀용)
    public List<BusinessClientVirtualBankAccount> getVirtualBankAccountsByBusinessClientIdsForExcel(List<Integer> businessOwnerIds) throws ApiException {
        List<BusinessClientVirtualBankAccount> virtualBankAccountList = new ArrayList<>();
        if (!businessOwnerIds.isEmpty()) {
            // get VirtualBankAccount list
            // TODO: prime api 배포 이후 20개씩 가져오는 로직을 제거
            for (int i = 0, sliceSize = 20; i < businessOwnerIds.size(); i += sliceSize) {
                List<Integer> sublist = businessOwnerIds.subList(i, i + sliceSize > businessOwnerIds.size() ? businessOwnerIds.size() : i + sliceSize);
                virtualBankAccountList.addAll(
                    intraVirtualBankAccountApiFactory.getApiClient(IntraApiTypeEnum.ACCOUNTING).getVirtualBankAccountsByBusinessClientIds(
                        intraTokenService.getAuthToken(),
                        new GetBusinessClientVirtualBankAccountsRequest().businessOwnerIds(sublist)
                    )
                );
            }
        }
        return virtualBankAccountList;
    }

    public Map<Integer, BusinessClientVirtualBankAccount> convertToMap(List<BusinessClientVirtualBankAccount> virtualBankAccounts) {
        HashMap<Integer, BusinessClientVirtualBankAccount> virtualBankMap = new HashMap<>();
        for (BusinessClientVirtualBankAccount virtualBankAccount : virtualBankAccounts) {
            virtualBankMap.put(virtualBankAccount.getBusinessOwnerId(), virtualBankAccount);
        }
        return virtualBankMap;
    }

}
