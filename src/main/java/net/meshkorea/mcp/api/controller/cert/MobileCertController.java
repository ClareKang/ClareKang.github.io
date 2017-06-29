package net.meshkorea.mcp.api.controller.cert;

import net.meshkorea.mcp.api.domain.model.kmc.CertRequest;
import net.meshkorea.mcp.api.domain.model.kmc.CertResponseDecrypt;
import net.meshkorea.mcp.api.domain.model.kmc.CertResultRequest;
import net.meshkorea.mcp.api.service.cert.MobileCertService;
import net.meshkorea.mcp.api.utils.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.Map;

/**
 * Created by yjhan on 2017. 6. 27..
 */
@Controller
@RequestMapping("/v1/cert/mobile/identification")
public class MobileCertController {

    @Autowired
    private MobileCertService mobileCertService;

    @GetMapping
    public String certRequestForm(Map<String, Object> model) {
        CertRequest certRequest = mobileCertService.createRequest();

        UriComponents uriComponents = ServletUriComponentsBuilder
            .fromCurrentServletMapping()
            .path("v1/cert/mobile/identification/callback/" + certRequest.getCertNum())
            .build()
            .encode();

        model.put("cert", certRequest.encrypt());
        model.put("callbackUrl", uriComponents.toUriString());
        model.put("domain", UrlUtils.getSiteDomain(uriComponents));

        return "cert_request_form";
    }

    @GetMapping(value = "/callback/{certNum}")
    public String handleCallback(@RequestParam("rec_cert") String recCert, @PathVariable("certNum") String certNum, Map<String, Object> model) {
        UriComponents uriComponents = ServletUriComponentsBuilder
            .fromCurrentServletMapping()
            .path("identification/result")
            .build()
            .encode();
        String resultUrl = uriComponents.toUriString();

        model.put("recCert", recCert);
        model.put("certNum", certNum);
        model.put("resultUrl", resultUrl);
        model.put("domain", UrlUtils.getSiteDomain(uriComponents));

        return "cert_popup_window";
    }

    @PostMapping(value = "/result")
    public String certResultForm(@ModelAttribute CertResultRequest certResultRequest, Map<String, Object> model) {
        UriComponents uriComponents = ServletUriComponentsBuilder
            .fromCurrentServletMapping()
            .build();

        String domain = UrlUtils.getSiteDomain(uriComponents);

        CertResponseDecrypt certResponse;
        try {
            certResponse = new CertResponseDecrypt(certResultRequest.getRecCert(), certResultRequest.getCertNum());
            model.put("domain", domain);
            model.put("result", certResponse.getResult());
            model.put("certId", certResponse.getCi());
        } catch (Exception e) {
            model.put("domain", domain);
            model.put("result", "F");
            model.put("certId", "");
        }
        return "cert_result";
    }

}
