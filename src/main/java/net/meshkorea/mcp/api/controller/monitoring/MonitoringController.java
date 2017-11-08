package net.meshkorea.mcp.api.controller.monitoring;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.ClaimRes;
import com.vroong.lastmile.api.client.model.OrderEventRes;
import net.meshkorea.mcp.api.service.monitoring.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/lastmile/monitoring")
public class MonitoringController {

    @Autowired
    MonitoringService monitoringService;

    @GetMapping("/order-events")
    public List<OrderEventRes> getOrderDetail(@RequestParam(value = "orderId", required = false) Long orderId,
                                              @RequestParam(value = "orderTrackingNumber", required = false) String orderTrackingNumber,
                                              @RequestParam(value = "vroongOrderNumber", required = false) String vroongOrderNumber,
                                              @RequestParam(value = "type", required = false) String type,
                                              @RequestParam(value = "page", required = false) Integer page,
                                              @RequestParam(value = "size", required = false) Integer size) throws ApiException {

        return monitoringService.findOrderEventList(orderId, orderTrackingNumber, vroongOrderNumber, type, page, size);
    }

    @GetMapping("/claims")
    public List<ClaimRes> findOrders(@RequestParam(value = "orderId", required = false) Long orderId,
                                     @RequestParam(value = "orderTrackingNumber", required = false) String orderTrackingNumber,
                                     @RequestParam(value = "vroongOrderNumber", required = false) String vroongOrderNumber,
                                     @RequestParam(value = "type", required = false) String type,
                                     @RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size) throws ApiException {

        return monitoringService.findClaimList(orderId, orderTrackingNumber, vroongOrderNumber, type, page, size);
    }

}


