package net.meshkorea.mcp.api.controller.delivery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meshprime.api.client.ApiException;

import net.meshkorea.mcp.api.service.delivery.DeliveryService;

/**
 * Created by jinho.kim on 2017. 10. 23..
 */
@RestController
@RequestMapping(value = "/v1/intra/delivery")
public class DeliveryController {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
    DeliveryService deliveryService;

    @RequestMapping(value = "/deliveries", method = RequestMethod.GET)
    public void findDeliveies(@RequestParam(value = "search_param", required = false, defaultValue = "") String search_param,
    						  @RequestParam(value = "search_query", required = false, defaultValue = "") String search_query,
    						  @RequestParam(value = "order_by", required = false, defaultValue = "") String order_by,
    						  @RequestParam(value = "preset", required = false, defaultValue = "") String preset,
    						  @RequestParam(value = "start_date", required = false, defaultValue = "") String start_date,
    						  @RequestParam(value = "end_date", required = false, defaultValue = "") String end_date,
    						  @RequestParam(value = "statuses", required = false, defaultValue = "") String statuses,
    						  @RequestParam(value = "size", required = false, defaultValue = "1") Integer size,
                              @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws ApiException {
    	
        deliveryService.findDeliveies(search_param, search_query, order_by, preset, start_date, end_date, statuses, size, page);
    }
}
