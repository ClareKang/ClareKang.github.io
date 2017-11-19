package net.meshkorea.mcp.api.controller.address;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.AddressSearchList;
import com.meshprime.api.client.model.ExtraFeeAddressList;
import net.meshkorea.mcp.api.service.address.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jinho.kim on 2017. 10. 25..
 */
@RestController
@RequestMapping(value = "/intra/v1/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/si_dos", method = RequestMethod.GET)
    public ExtraFeeAddressList getSiDos(@RequestParam(value = "si_do", required = false) String si_do) throws ApiException {
        logger.info("si_do : {}", si_do);
        return addressService.getSidoList(si_do);
    }

    @GetMapping("/si_gun_gus")
    public ExtraFeeAddressList getSiGunGus(
            String si_do,
            String si_gun_gu) throws ApiException {
        return addressService.getSiGunGuList(si_do, si_gun_gu);
    }

    @RequestMapping(value = "/legal_dongs", method = RequestMethod.GET)
    public ExtraFeeAddressList getLegalDongs(@RequestParam(value = "si_do", required = true) String si_do,
                                             @RequestParam(value = "si_gun_gu", required = true) String si_gun_gu,
                                             @RequestParam(value = "keyword", required = false) String keyword) throws ApiException {
        logger.info("si_do : {}, si_gun_gu : {}, keyword: {}", si_do, si_gun_gu, keyword);
        return addressService.getLegalDongList(si_do, si_gun_gu, keyword);
    }

    @RequestMapping(value = "/legal_ris", method = RequestMethod.GET)
    public AddressSearchList getLegaRis(@RequestParam(value = "si_do", required = true) String si_do,
                                        @RequestParam(value = "si_gun_gu", required = true) String si_gun_gu,
                                        @RequestParam(value = "legal_dong", required = true) String legal_dong,
                                        @RequestParam(value = "keyword", required = false) String keyword) throws ApiException {
        logger.info("si_do : {}, si_gun_gu : {}, legal_dong : {}, keyword: {}", si_do, si_gun_gu, legal_dong, keyword);
        return addressService.getLegalRiList(si_do, si_gun_gu, legal_dong, keyword);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public AddressSearchList getAddresses(@RequestParam(value = "si_do", required = true) String si_do,
                                          @RequestParam(value = "si_gun_gu", required = true) String si_gun_gu,
                                          @RequestParam(value = "legal_dong", required = true) String legal_dong,
                                          @RequestParam(value = "legal_ri", required = false) String legal_ri,
                                          @RequestParam(value = "address_type", required = true) String address_type,
                                          @RequestParam(value = "keyword", required = true) String keyword,
                                          @RequestParam(value = "search_type", required = false) String search_type,
                                          @RequestParam(value = "page", required = false) String page,
                                          @RequestParam(value = "size", required = false) String size
    ) throws ApiException {
        logger.info("page : {}, size : {}", page, size);
        return addressService.getSearchList(si_do, si_gun_gu, legal_dong, legal_ri, address_type, keyword, search_type, page, size);
    }

}
