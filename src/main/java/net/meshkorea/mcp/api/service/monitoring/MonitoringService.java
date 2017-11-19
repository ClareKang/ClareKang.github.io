package net.meshkorea.mcp.api.service.monitoring;

import com.vroong.lastmile.api.LastmileMonitoringApi;
import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.ClaimRes;
import com.vroong.lastmile.api.client.model.OrderEventRes;
import com.vroong.lastmile.service.auth.LastmileTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoringService {

    @Autowired
    LastmileTokenService lastmileTokenService;

    @Autowired
    LastmileMonitoringApi lastmileMonitoringApi;

    public List<OrderEventRes> findOrderEventList(Long orderId,
                                                  String orderTrackingNumber,
                                                  String vroongOrderNumber,
                                                  String type,
                                                  Integer page,
                                                  Integer size) throws ApiException {

        return lastmileMonitoringApi.findOrderEventsUsingGET(lastmileTokenService.getAuthToken(),
                orderId,
                orderTrackingNumber,
                vroongOrderNumber,
                type,
                page,
                size);
    }

    public List<ClaimRes> findClaimList(Long orderId,
                                        String orderTrackingNumber,
                                        String vroongOrderNumber,
                                        String type,
                                        Integer page,
                                        Integer size) throws ApiException {

        return lastmileMonitoringApi.findClaimsUsingGET(lastmileTokenService.getAuthToken(),
                orderId,
                orderTrackingNumber,
                vroongOrderNumber,
                type,
                page,
                size);
    }
    
}
