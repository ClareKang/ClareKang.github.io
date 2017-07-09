package net.meshkorea.mcp.api.controller.monitoring;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.monitoring.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping("/v1/lastmile/live")
public class LiveController {

    @Autowired
    LiveService liveService;

    @PostMapping("/findOrders")
    public ManagerFindOrdersRes findOrders(@RequestBody ManagerFindOrdersReq req) throws ApiException {
        return liveService.findOrders(req);
    }

    @PostMapping("/getOrderDetail")
    public ManagerGetOrderDetailRes getOrderDetail(ManagerGetOrderDetailReq req) throws ApiException {
        return liveService.getOrderDetail(req);
    }

    @PostMapping("/updateOrder")
    public ManagerUpdateOrderRes updateOrder(@RequestBody ManagerUpdateOrderReq req) throws ApiException {
        return liveService.updateOrder(req);
    }

    @PostMapping("/exportExcel")
    public ResponseEntity<Resource> exportExcelFile(@RequestBody ManagerFindOrdersReq req) throws Exception {
        return liveService.excelFindOrder(req);
    }

    @PostMapping("/pricingPlan")
    public ManagerPricingPlanRes pricingPlan() throws ApiException {
        return liveService.pricingPlan();
    }

    @PostMapping("/getBaseCharge")
    public ManagerGetBaseChargeRes getBaseCharge(@RequestBody ManagerGetBaseChargeReq req) throws ApiException {
        return liveService.getBaseCharge(req);
    }

    @PostMapping("/changeStatus")
    public ManagerChangeStatusRes changeStatus(ManagerChangeStatusReq req) throws ApiException {
        return liveService.changeStatus(req);
    }

    @PostMapping("/getOrderStatusForAssign")
    public ManagerGetOrderStatusForAssignRes getOrderStatusForAssign(ManagerGetOrderStatusForAssignReq req) throws ApiException {
        return liveService.getOrderStatusForAssign(req);
    }

    @PostMapping("/assignAgent")
    public ManagerAssignAgentRes assignAgent(@RequestBody ManagerAssignAgentReq req) throws ApiException {
        return liveService.assignAgent(req);
    }

    @PostMapping("/getOrderHistory")
    public ManagerGetOrderHistoryRes getOrderHistory(ManagerGetOrderHistoryReq req) throws ApiException {
        return liveService.getOrderHistory(req);
    }

    @PostMapping("/getOrderPayHistoryAppendResult")
    public ManagerGetOrderPayHistoryRes getOrderPayHistoryAppendResult(ManagerGetOrderPayHistoryReq req) throws ApiException {
        return liveService.getOrderPayHistoryAppendResult(req);
    }

    @PostMapping("/makePayments")
    public ManagerMakeMultiPaymentRes makePayments(@RequestBody ManagerMakeMultiPaymentReq req) throws ApiException {
        return liveService.makePayments(req);
    }

    @PostMapping("/updatePayment")
    public ManagerUpdatePaymentRes updatePayment(@RequestBody ManagerUpdatePaymentReq req) throws ApiException {
        return liveService.updatePayment(req);
    }

    @PostMapping("/cancelPayments")
    public ManagerCancelMultiPaymentRes cancelPayments(@RequestBody ManagerCancelMultiPaymentReq req) throws ApiException {
        return liveService.cancelPayments(req);
    }
}


