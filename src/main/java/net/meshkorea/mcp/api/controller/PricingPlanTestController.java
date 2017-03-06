package net.meshkorea.mcp.api.controller;

import net.meshkorea.mcp.api.service.JpaTestService;
import net.meshkorea.mcp.api.service.LdapAuthenticationService;
import net.meshkorea.mcp.api.service.MapperTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yjhan on 2017. 2. 14..
 */
@RestController
public class PricingPlanTestController {

    @Autowired
    JpaTestService jpaTestService;

    @Autowired
    LdapAuthenticationService ldapAuthenticationService;

    @Autowired
    MapperTestService mapperTestService;

    @RequestMapping(value = "/pricingPlan/{deliveryClassId}", method = RequestMethod.GET)
    public String getPricingPlan(@PathVariable Long deliveryClassId) {
        return jpaTestService.getDeliveryClassCode(deliveryClassId);
        // return "VROONG_DEFAULT";
    }

    @RequestMapping(value = "/getUserDataByLdap", method = RequestMethod.GET)
    //public String getUserDateByLdap(@PathVariable String uid){
    public String getUserDateByLdap(@RequestParam String uid){
        System.out.println(uid);
        return ldapAuthenticationService.getLdapUserData(uid).toString();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        return "main page, session : " + request.getSession().getAttribute("name")+", attr : " + request.getAttribute("auth");
    }

    @RequestMapping(value = "/getUserAuthList", method = RequestMethod.GET)
    public String getUserAuthList(HttpServletRequest request, HttpServletResponse response){
        String text = "";
        HashMap<String, Object> map = new HashMap<String, Object>();
        //map = mapperTestService.getAuthList(request.getSession().getAttribute("id").toString());
        System.out.println("Controller : " + request.getSession().getAttribute("name").toString());
        text = mapperTestService.getAuthList(request.getSession().getAttribute("name").toString()).toString();

        return text;
    }

}
