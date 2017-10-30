package net.meshkorea.mcp.api.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meshprime.api.client.ApiException;
import com.meshprime.intra.api.IntraDeliveriesApi;
import com.meshprime.intra.service.auth.IntraTokenService;

/**
 * Created by jinho.kim on 2017. 10. 23..
 */
@Service
public class DeliveryService {
	
	@Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraDeliveriesApi intraDeliveriesApi;
    
    public void findDeliveies(String search_param, String search_query, String order_by, String preset, String start_date, String end_date, String statuses, int size, int page) throws ApiException{
        intraDeliveriesApi.listDeliveries(intraTokenService.getAuthToken(), search_param, search_query, order_by, preset, start_date, end_date, statuses, size, page);
    }
}
