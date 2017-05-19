package net.meshkorea.mcp.api.controller.address;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.ExtraFeeAddressList;
import net.meshkorea.mcp.api.service.address.RegionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sungjae.hong on 2017. 5. 4..
 */
@RestController
@RequestMapping(value = "/v1/intra/regions")
public class RegionsController {

    @Autowired
    RegionsService regionsService;

    Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/si_dos", method = RequestMethod.GET)
    public ExtraFeeAddressList getSiDos(@RequestParam(value = "si_do", required = false) String si_do) throws ApiException {
        logger.info("si_do : {}", si_do);
        return regionsService.getSidoList(si_do);
    }

    @GetMapping("/si_gun_gus")
    public ExtraFeeAddressList getSiGunGus(
        String si_do,
        String si_gun_gu) throws ApiException {
        return regionsService.getSiGunGuList(si_do, si_gun_gu);
    }

    @RequestMapping(value = "/legal_dongs", method = RequestMethod.GET)
    public ExtraFeeAddressList getLegalDongs(@RequestParam(value = "si_do", required = false) String si_do,
                                             @RequestParam(value = "si_gun_gu", required = false) String si_gun_gu,
                                             @RequestParam(value = "keyword", required = false) String keyword) throws ApiException {
        logger.info("si_do : {}, si_gun_gu : {}, keyword: {}", si_do, si_gun_gu, keyword);
        return regionsService.getLegalDongList(si_do, si_gun_gu, keyword);
    }

    @RequestMapping(value = "/admin_dongs", method = RequestMethod.GET)
    public ExtraFeeAddressList getAdminDongs(@RequestParam(value = "si_do", required = false) String si_do,
                                             @RequestParam(value = "si_gun_gu", required = false) String si_gun_gu,
                                             @RequestParam(value = "keyword", required = false) String keyword) throws ApiException {
        logger.info("si_do : {}, si_gun_gu : {}, keyword: {}", si_do, si_gun_gu, keyword);
        return regionsService.getAdminDongList(si_do, si_gun_gu, keyword);
    }

    @RequestMapping(value = "/road_names", method = RequestMethod.GET)
    public ExtraFeeAddressList getRoadNames(@RequestParam(value = "si_do", required = false) String si_do,
                                            @RequestParam(value = "si_gun_gu", required = false) String si_gun_gu,
                                            @RequestParam(value = "keyword", required = false) String keyword) throws ApiException {
        logger.info("si_do : {}, si_gun_gu : {}, keyword: {}", si_do, si_gun_gu, keyword);
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ExtraFeeAddressList getAddresses(@RequestParam(value = "si_do", required = false) String si_do,
                                            @RequestParam(value = "si_gun_gu", required = false) String si_gun_gu,
                                            @RequestParam(value = "keyword", required = false) String keyword,
                                            @RequestParam(value = "page", required = false) String page,
                                            @RequestParam(value = "size", required = false) String size
    ) throws ApiException {
        logger.info("page : {}, size : {}", page, size);
        return regionsService.getAddressList(si_do, si_gun_gu, keyword, page, size);
    }

}
