package com.meshprime.intra.api;

import com.meshprime.api.client.api.SubscriptionsApi;
import com.meshprime.common.constant.IntraApiTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({
    "intraSubscriptionApi",
    "intraAccountingSubscriptionApi"
})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IntraSubscriptionApiFactory {

    private final IntraSubscriptionApi intraSubscriptionApi;

    private final IntraAccountingSubscriptionApi intraAccountingSubscriptionApi;

    public SubscriptionsApi getApiClient(IntraApiTypeEnum apiType) {
        switch (apiType) {
            case ACCOUNTING:
                return intraAccountingSubscriptionApi;
            case MAIN:
            default:
                return intraSubscriptionApi;
        }
    }
}
