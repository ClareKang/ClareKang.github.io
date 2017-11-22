package com.meshprime.intra.api;

import com.meshprime.api.client.api.VirtualBankAccountsApi;
import com.meshprime.common.constant.IntraApiTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({
    "intraVirtualBankAccountApi",
    "intraAccountingVirtualBankAccountApi"
})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IntraVirtualBankAccountApiFactory {

    private final IntraVirtualBankAccountApi intraVirtualBankAccountApi;

    private final IntraAccountingVirtualBankAccountApi intraAccountingVirtualBankAccountApi;

    public VirtualBankAccountsApi getApiClient(IntraApiTypeEnum apiType) {
        switch (apiType) {
            case ACCOUNTING:
                return intraAccountingVirtualBankAccountApi;
            case MAIN:
            default:
                return intraVirtualBankAccountApi;
        }
    }
}
