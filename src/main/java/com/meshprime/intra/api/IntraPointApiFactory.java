package com.meshprime.intra.api;

import com.meshprime.api.client.api.PointApi;
import com.meshprime.common.constant.IntraApiTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({
    "intraPointApi",
    "intraAccountingPointApi"
})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IntraPointApiFactory {

    private final IntraPointApi intraPointApi;

    private final IntraAccountingPointApi intraAccountingPointApi;

    public PointApi getApiClient(IntraApiTypeEnum apiType) {
        switch (apiType) {
            case ACCOUNTING:
                return intraAccountingPointApi;
            case MAIN:
            default:
                return intraPointApi;
        }
    }
}
