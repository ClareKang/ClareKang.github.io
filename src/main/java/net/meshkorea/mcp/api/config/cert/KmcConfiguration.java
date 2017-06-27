package net.meshkorea.mcp.api.config.cert;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class KmcConfiguration {

    @Value("${kmc.cert.companyId}")
    private String companyId;

    @Value("${kmc.cert.urlCode}")
    private String urlCode;

}
