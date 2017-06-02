package net.meshkorea.mcp.api.service.monitoring;

import com.vroong.lastmile.api.LastmileManagerOrderApi;
import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import com.vroong.lastmile.service.auth.LastmileTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jypark on 2017. 5. 30..
 */
@Service
public class LiveService {

    @Autowired
    LastmileTokenService lastmileTokenService;

    @Autowired
    LastmileManagerOrderApi lastmileManagerOrderApi;

    public ManagerAssignAgentRes assignAgent(ManagerAssignAgentReq req) throws ApiException {
        return lastmileManagerOrderApi.assignAgentUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerCanProcessOrderRes canProcessOrder(ManagerCanProcessOrderReq req) throws ApiException {
        return lastmileManagerOrderApi.canProcessOrderUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerCancelOrderRes cancelOrder(ManagerCancelOrderReq req) throws ApiException {
        return lastmileManagerOrderApi.cancelOrderUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerCancelPaymentRes cancelPayment(ManagerCancelPaymentReq req) throws ApiException {
        return lastmileManagerOrderApi.cancelPaymentUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerCancelMultiPaymentRes cancelPayments(ManagerCancelMultiPaymentReq req) throws ApiException {
        return lastmileManagerOrderApi.cancelPaymentsUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerChangeStatusRes changeStatus(ManagerChangeStatusReq req) throws ApiException {
        return lastmileManagerOrderApi.changeStatusUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerCreateOrderRes createOrder(ManagerCreateOrderReq req) throws ApiException {
        return lastmileManagerOrderApi.createOrderUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerDeliverOrderRes deliverOrder(ManagerDeliverOrderReq req) throws ApiException {
        return lastmileManagerOrderApi.deliverOrderUsingPOST1(lastmileTokenService.getAuthToken(), req);
    }

    // excelFindOrders ??

    public ManagerFindMonitoringAndSalesOrdersRes findMonitoringAndSalesOrders(ManagerFindMonitoringAndSalesOrdersReq req) throws ApiException {
        return lastmileManagerOrderApi.findMonitoringAndSalesOrdersUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerFindOrdersRes findOrders(ManagerFindOrdersReq req) throws ApiException {
        return lastmileManagerOrderApi.findOrdersUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerGetBaseChargeRes getBaseChargeUsing(ManagerGetBaseChargeReq req) throws ApiException {
        return lastmileManagerOrderApi.getBaseChargeUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerGetOrderDetailRes getOrderDetail(ManagerGetOrderDetailReq req) throws ApiException {
        return lastmileManagerOrderApi.getOrderDetailUsingPOST1(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerGetOrderHistoryRes getOrderHistory(ManagerGetOrderHistoryReq req) throws ApiException {
        return lastmileManagerOrderApi.getOrderHistoryUsingPOST1(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerGetOrderPayHistoryRes getOrderPayHistoryAppendResult(ManagerGetOrderPayHistoryReq req) throws ApiException {
        return lastmileManagerOrderApi.getOrderPayHistoryAppendResultUsingPOST1(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerGetOrderStatusForAssignRes getOrderStatusForAssign(ManagerGetOrderStatusForAssignReq req) throws ApiException {
        return lastmileManagerOrderApi.getOrderStatusForAssignUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    // getSignatureImage ??

    public ManagerListPartnerOrdersRes listPartnerOrders(ManagerListPartnerOrdersReq req) throws ApiException {
        return lastmileManagerOrderApi.listPartnerOrdersUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerMakePaymentRes makePayment(ManagerMakePaymentReq req) throws ApiException {
        return lastmileManagerOrderApi.makePaymentUsingPOST1(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerMakeMultiPaymentRes makePayments(ManagerMakeMultiPaymentReq req) throws ApiException {
        return lastmileManagerOrderApi.makePaymentsUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerPickUpOrderRes pickUpOrder(ManagerPickUpOrderReq req) throws ApiException {
        return lastmileManagerOrderApi.pickUpOrderUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerPricingPlanRes pricingPlan() throws ApiException {
        return lastmileManagerOrderApi.pricingPlanUsingPOST(lastmileTokenService.getAuthToken());
    }

    public ManagerSetExpectedDeliveryTimeRes setExpectedDeliveryTime(ManagerSetExpectedDeliveryTimeReq req) throws ApiException {
        return lastmileManagerOrderApi.setExpectedDeliveryTimeUsingPOST1(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerSubmitOrderRes submitOrder(ManagerSubmitOrderReq req) throws ApiException {
        return lastmileManagerOrderApi.submitOrderUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerTrackOrdersRes trackOrders(ManagerTrackOrdersReq req) throws ApiException {
        return lastmileManagerOrderApi.trackOrdersUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerUnAssignAgentRes unAssignAgent(ManagerUnAssignAgentReq req) throws ApiException {
        return lastmileManagerOrderApi.unAssignAgentUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerUndoDeliverOrderRes undoDeliverOrder(ManagerUndoDeliverOrderReq req) throws ApiException {
        return lastmileManagerOrderApi.undoDeliverOrderUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerUndoSubmitOrderRes undoSubmitOrder(ManagerUndoSubmitOrderReq req) throws ApiException {
        return lastmileManagerOrderApi.undoSubmitOrderUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerUpdateOrderRes updateOrder(ManagerUpdateOrderReq req) throws ApiException {
        return lastmileManagerOrderApi.updateOrderUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerUpdatePaymentRes updatePayment(ManagerUpdatePaymentReq req) throws ApiException {
        return lastmileManagerOrderApi.updatePaymentUsingPOST(lastmileTokenService.getAuthToken(), req);
    }



}
