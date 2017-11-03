package net.meshkorea.mcp.api.domain.model.claim2;

/**
 * <pre>
 *  ORDER_CANCEL: 오더취소
 *  OVERLOAD: 과적
 *  RETURN: 반납
 *  RETRY: 재이동
 *  ADDRESS_CHANGE: 주소변경
 *  PHONE_PAYMENT: 전화결제
 *  DAMEGE: 손해배상
 * </pre>
 *
 */
public enum ClaimType {
    ORDER_CANCEL,   // 오더취소
    OVERLOAD,       // 과적
    RETURN,         // 반납
    RETRY,          // 재이동
    ADDRESS_CHANGE, // 주소변경
    PHONE_PAYMENT,  // 전화결제
    DAMEGE          // 손해배상
}
