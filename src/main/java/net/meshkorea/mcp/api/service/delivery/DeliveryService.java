package net.meshkorea.mcp.api.service.delivery;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import com.meshprime.intra.api.IntraDeliveriesApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jinho.kim on 2017. 10. 23..
 */
@Service
public class DeliveryService {

    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraDeliveriesApi intraDeliveriesApi;

    public DeliveryList findDeliveies(String search_param, String search_query, String order_by, String preset, String start_date, String end_date, String statuses, int size, int page) throws ApiException {
        return intraDeliveriesApi.listDeliveries(intraTokenService.getAuthToken(), statuses, search_param, search_query, order_by, preset, start_date, end_date, page, size);
    }

    public EstimatedShippingInfoResponse getEstimatedShippingInfo(EstimatedShippingInfoRequest body) throws ApiException {
        return intraDeliveriesApi.getEstimatedShippingInfo(intraTokenService.getAuthToken(), body);
    }

    public void changeOriginAddress(ChangeOriginAddressRequest body) throws ApiException {
        intraDeliveriesApi.changeOriginAddress(intraTokenService.getAuthToken(), body);
    }

    public void changeDestAddress(ChangeDestAddressRequest body) throws ApiException {
        intraDeliveriesApi.changeDestAddress(intraTokenService.getAuthToken(), body);
    }
}
