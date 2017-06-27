package net.meshkorea.mcp.api.service.cert;

import net.meshkorea.mcp.api.config.cert.KmcConfiguration;
import net.meshkorea.mcp.api.domain.model.kmc.CertRequest;
import net.meshkorea.mcp.api.domain.model.kmc.CertRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class CertService {

    @Autowired
    private KmcConfiguration kmcConfiguration;

    public CertRequest createRequest() {
        String certNum = UUID.randomUUID().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String cpId = kmcConfiguration.getCompanyId();
        String urlCode = kmcConfiguration.getUrlCode();

        String date = formatter.format(LocalDateTime.now());
        String certMethod = "M";
        String extendVar = "0000000000000000";

        CertRequestBuilder builder = new CertRequestBuilder()
            .setCpId(cpId)
            .setUrlCode(urlCode)
            .setCertNum(certNum)
            .setDate(date)
            .setCertMethod(certMethod)
            .setExtendVar(extendVar);

        return builder.createCertRequest();
    }
}
