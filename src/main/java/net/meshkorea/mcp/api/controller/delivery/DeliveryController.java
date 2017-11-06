package net.meshkorea.mcp.api.controller.delivery;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import net.meshkorea.mcp.api.service.delivery.DeliveryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/v1/intra/delivery_quotes", method = RequestMethod.POST)
    public EstimatedShippingInfoResponse getEstimatedShippingInfo(@RequestBody String parameter) throws ApiException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = gsonBuilder.create();

        EstimatedShippingInfoRequest estimatedShippingInfoRequest =
                gson.fromJson(parameter, EstimatedShippingInfoRequest.class);

        // "DEST_ADDRESS" | "ORIGIN_ADDRESS"
        if (StringUtils.equals(estimatedShippingInfoRequest.getAddressContext(), "DEST_ADDRESS")
                && estimatedShippingInfoRequest.getDestAddress() == null) {
            throw new ApiException("dest_address is required.");

        } else if (StringUtils.equals(estimatedShippingInfoRequest.getAddressContext(), "ORIGIN_ADDRESS")
                && estimatedShippingInfoRequest.getOriginAddress() == null) {
            throw new ApiException("origin_address is required.");
        }

        return deliveryService.getEstimatedShippingInfo(estimatedShippingInfoRequest);
    }

    @RequestMapping(value = "/v1/intra/deliveries/origin_address", method = RequestMethod.PUT)
    public void changeOriginAddress(@RequestBody String parameter) throws ApiException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = gsonBuilder.create();

        ChangeOriginAddressRequest changeOriginAddressRequest =
                gson.fromJson(parameter, ChangeOriginAddressRequest.class);

        deliveryService.changeOriginAddress(changeOriginAddressRequest);
    }

    @RequestMapping(value = "/v1/intra/deliveries/dest_address", method = RequestMethod.PUT)
    public void changeDestAddress(@RequestBody String parameter) throws ApiException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = gsonBuilder.create();

        ChangeDestAddressRequest changeDestAddressRequest =
                gson.fromJson(parameter, ChangeDestAddressRequest.class);

        deliveryService.changeDestAddress(changeDestAddressRequest);
    }

}
