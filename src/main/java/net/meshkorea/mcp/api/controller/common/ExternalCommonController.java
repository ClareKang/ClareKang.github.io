package net.meshkorea.mcp.api.controller.common;

import com.sk.api.client.poi.model.dto.PoiResultDto;
import net.meshkorea.mcp.api.service.common.ExternalCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by reverof on 2017-05-10.
 */
@RestController
@RequestMapping(value = "/v1/external")
public class ExternalCommonController {

    @Autowired
    ExternalCommonService externalCommonService;

    @GetMapping("/poi/address")
    public PoiResultDto getAddress(String searchKeyword) throws Exception {
        return externalCommonService.getAddress(searchKeyword);
    }

}
