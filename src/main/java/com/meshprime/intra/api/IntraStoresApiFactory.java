package com.meshprime.intra.api;

import com.meshprime.api.client.api.StoresApi;
import com.meshprime.common.constant.IntraApiTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({
    "intraStoresApi",
    "intraAccountingStoresApi"
})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IntraStoresApiFactory {

    private final IntraStoresApi intraStoresApi;

    private final IntraAccountingStoresApi intraAccountingStoresApi;

    public StoresApi getApiClient(IntraApiTypeEnum apiType) {
        switch (apiType) {
            case ACCOUNTING:
                return intraAccountingStoresApi;
            case MAIN:
            default:
                return intraStoresApi;
        }
    }
}
