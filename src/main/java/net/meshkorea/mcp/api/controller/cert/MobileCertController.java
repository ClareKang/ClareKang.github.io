package net.meshkorea.mcp.api.controller.cert;

import net.meshkorea.mcp.api.domain.model.cert.MobileCertIdentificationResponse;
import net.meshkorea.mcp.api.domain.model.cert.MobileCertResponse;
import net.meshkorea.mcp.api.domain.model.kmc.CertRequest;
import net.meshkorea.mcp.api.domain.model.kmc.CertResponseDecrypt;
import net.meshkorea.mcp.api.service.cert.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * Created by yjhan on 2017. 6. 27..
 */
@RestController
@RequestMapping("/v1/cert/mobile")
public class MobileCertController {

    @Autowired
    private CertService certService;

    @GetMapping(value = "/identification")
    public MobileCertIdentificationResponse getCertRequestData() {
        CertRequest certRequest = certService.createRequest();

        UriComponents uriComponents = ServletUriComponentsBuilder
            .fromCurrentServletMapping()
            .path("v1/cert/mobile/identification/callback/" + certRequest.getCertNum())
            .build();
        String callbackUrl = uriComponents.encode().toUriString();

        return new MobileCertIdentificationResponse(certRequest.encrypt(), certRequest.getCertNum(), callbackUrl);
    }

    @GetMapping(value = "/identification/callback/{certNum}")
    public MobileCertResponse handleCallback(@RequestParam("rec_cert") String recCert, @PathVariable("certNum") String certNum) {

        MobileCertResponse response = new MobileCertResponse();

        try {
            CertResponseDecrypt certResponseDecrypt = new CertResponseDecrypt(recCert, certNum);
            response.setResult(certResponseDecrypt.getResult());
            response.setCertId(certResponseDecrypt.getCi());
        } catch (Exception e) {
            response.setResult("F");
            response.setCertId("");
        }

        // TODO: 여기 push 로 보내도록 수정
        return response;
    }

}
