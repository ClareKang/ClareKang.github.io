package net.meshkorea.mcp.api.controller.business;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@Controller
public class PartnerController {

    @Autowired
    PartnerService partnerService;

    @RequestMapping(value = "/findPartners", method = RequestMethod.POST)
    public @ResponseBody
    ManagerFindPartnersRes findPartners(ManagerFindPartnersReq req) throws ApiException {
        return partnerService.findPartners(req);
    }

    @RequestMapping(value = "/getPartnerDetail", method = RequestMethod.POST)
    public @ResponseBody
    ManagerGetPartnerDetailRes getPartnerDetail(ManagerGetPartnerDetailReq req) throws ApiException {
        return partnerService.getPartnerDetail(req);
    }

    @RequestMapping(value = "/addPartner", method = RequestMethod.POST)
    public ManagerAddPartnerRes addPartner(ManagerAddPartnerReq req) throws ApiException {
        return partnerService.addPartner(req);
    }

    @RequestMapping(value = "/removePartner", method = RequestMethod.POST)
    public ManagerRemovePartnerRes removePartner(ManagerRemovePartnerReq req) throws  ApiException {
        return partnerService.removePartner(req);
    }

    @RequestMapping(value = "/updatePartner", method = RequestMethod.POST)
    public @ResponseBody
    ManagerUpdatePartnerRes updatePartner(ManagerUpdatePartnerReq req) throws ApiException {
        return partnerService.updatepartner(req);
    }

    @RequestMapping(value = "/listAllPartners", method = RequestMethod.GET)
    public @ResponseBody ManagerListAllPartnersRes listAllPartners() throws ApiException {
        return partnerService.listAllPartners();
    }
}
