package net.meshkorea.mcp.api.controller.delivery;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.ChangeDestAddressRequest;
import com.meshprime.api.client.model.DeliveryList;
import com.meshprime.api.client.model.EstimatedShippingInfoRequest;
import net.meshkorea.mcp.api.service.delivery.DeliveryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by jinho.kim on 2017. 10. 23..
 */
@RestController
public class DeliveryController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DeliveryService deliveryService;

    @RequestMapping(value = "/v1/intra/deliveries", method = RequestMethod.GET)
    public DeliveryList findDeliveies(@RequestParam(value = "search_param", required = false, defaultValue = "") String search_param,
                                      @RequestParam(value = "search_query", required = false, defaultValue = "") String search_query,
                                      @RequestParam(value = "order_by", required = false, defaultValue = "") String order_by,
                                      @RequestParam(value = "preset", required = false, defaultValue = "") String preset,
                                      @RequestParam(value = "start_date", required = false, defaultValue = "") String start_date,
                                      @RequestParam(value = "end_date", required = false, defaultValue = "") String end_date,
                                      @RequestParam(value = "statuses", required = false, defaultValue = "") String statuses,
                                      @RequestParam(value = "size", required = false, defaultValue = "1") Integer size,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws ApiException {

        return deliveryService.findDeliveies(search_param, search_query, order_by, preset, start_date, end_date, statuses, size, page);
    }

    @RequestMapping(value = "/v1/intra/delivery_quotes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getEstimatedShippingInfo(@RequestBody EstimatedShippingInfoRequest req) throws ApiException {
        // "DEST_ADDRESS" | "ORIGIN_ADDRESS"
        if (StringUtils.equals(req.getAddressContext(), "DEST_ADDRESS")
                && req.getDestAddress() == null) {
            throw new ApiException("dest_address is required.");

        } else if (StringUtils.equals(req.getAddressContext(), "ORIGIN_ADDRESS")
                && req.getOriginAddress() == null) {
            throw new ApiException("origin_address is required.");
        }

        try {
            return ResponseEntity.ok(deliveryService.getEstimatedShippingInfo(req));
        } catch (ApiException primeApiException) {
            return ResponseEntity.badRequest().body(primeApiException.getResponseBody());
        }
    }

    @RequestMapping(value = "/v1/intra/deliveries/dest_address", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeDestAddress(@RequestBody ChangeDestAddressRequest req) throws ApiException {

        try {
            deliveryService.changeDestAddress(req);

            HashMap result = new HashMap();
            result.put("success", true);
            return ResponseEntity.ok(result);

        } catch (ApiException primeApiException) {
            return ResponseEntity.badRequest().body(primeApiException.getResponseBody());
        }
    }

}
