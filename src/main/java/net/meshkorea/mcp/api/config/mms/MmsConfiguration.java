package net.meshkorea.mcp.api.config.mms;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@Component
@Getter
public class MmsConfiguration {

    @Value("${mms.callbackNum}")
    private String callbackNumber;

    @Value("${mms.transfer.maxReceiverAtOnce}")
    private Integer maxReceiverAtOnce;

}
