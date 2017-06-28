package net.meshkorea.mcp.api.controller.cert;

import net.meshkorea.mcp.api.domain.model.cert.MobileCertResponse;
import net.meshkorea.mcp.api.domain.model.kmc.CertRequest;
import net.meshkorea.mcp.api.domain.model.kmc.CertResponseDecrypt;
import net.meshkorea.mcp.api.service.cert.CertService;
import org.bouncycastle.asn1.cmp.CertResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.Map;

/**
 * Created by yjhan on 2017. 6. 27..
 */
@Controller
@RequestMapping("/v1/cert/mobile")
public class MobileCertController {

    @Autowired
    private CertService certService;

    @GetMapping(value = "/identification")
    public String getCertRequestData(Map<String, Object> model) {
        CertRequest certRequest = certService.createRequest();

        UriComponents uriComponents = ServletUriComponentsBuilder
            .fromCurrentServletMapping()
            .path("v1/cert/mobile/identification/callback/" + certRequest.getCertNum())
            .build();
        String callbackUrl = uriComponents.encode().toUriString();

        model.put("cert", certRequest.encrypt());
        model.put("callbackUrl", callbackUrl);

        return "cert_request_form";
    }

    @GetMapping(value = "/identification/callback/{certNum}")
    public String handleCallback(@RequestParam("rec_cert") String recCert, @PathVariable("certNum") String certNum, Map<String, Object> model) {

        CertResponseDecrypt certResponse;
        try {
            certResponse = new CertResponseDecrypt(recCert, certNum);
            model.put("result", certResponse.getResult());
            model.put("certId", certResponse.getCi());
        } catch (Exception e) {
            model.put("result", "F");
            model.put("certId", "");
        }
        return "cert_result";
    }

}
