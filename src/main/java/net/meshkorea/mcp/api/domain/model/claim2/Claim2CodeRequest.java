package net.meshkorea.mcp.api.domain.model.claim2;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.meshkorea.mcp.api.domain.model.database.Yn;

import javax.validation.constraints.NotNull;

public class Claim2CodeRequest {

    @Data
    public static class AddClaimCode {
        @ApiModelProperty(value = "사용자 식별자(이메일)", required = true)
        @NotNull(message = "email is required.")
        private String email;

        @ApiModelProperty(value = "클레임 코드명", allowableValues = "Y, N", required = true)
        @NotNull(message = "claimCodeName is required.")
        private String claimCodeName;

        @ApiModelProperty(value = "오더취소 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "orderCancelYn is required.")
        private Yn orderCancelYn;

        @ApiModelProperty(value = "과적 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "overloadYn is required.")
        private Yn overloadYn;

        @ApiModelProperty(value = "반납 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "returnYn is required.")
        private Yn returnYn;

        @ApiModelProperty(value = "재이동 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "retryYn is required.")
        private Yn retryYn;

        @ApiModelProperty(value = "주소변경 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "addressChangeYn is required.")
        private Yn addressChangeYn;

        @ApiModelProperty(value = "전화결제 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "phonePaymentYn is required.")
        private Yn phonePaymentYn;

        @ApiModelProperty(value = "손해배상 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "damegeYn is required.")
        private Yn damegeYn;

        @ApiModelProperty(value = "클레임코드 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "useYn is required.")
        private Yn useYn;
    }

    @Data
    public static class ModifyClaimCode {
        @ApiModelProperty(value = "사용자 식별자(이메일)", required = true)
        @NotNull(message = "email is required.")
        private String email;

        @ApiModelProperty(value = "클레임 식별자", allowableValues = "Y, N", required = true)
        @NotNull(message = "claimCodeNo is required.")
        private Long claimCodeNo;

        @ApiModelProperty(value = "오더취소 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "orderCancelYn is required.")
        private Yn orderCancelYn;

        @ApiModelProperty(value = "과적 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "overloadYn is required.")
        private Yn overloadYn;

        @ApiModelProperty(value = "반납 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "returnYn is required.")
        private Yn returnYn;

        @ApiModelProperty(value = "재이동 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "retryYn is required.")
        private Yn retryYn;

        @ApiModelProperty(value = "주소변경 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "addressChangeYn is required.")
        private Yn addressChangeYn;

        @ApiModelProperty(value = "전화결제 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "phonePaymentYn is required.")
        private Yn phonePaymentYn;

        @ApiModelProperty(value = "손해배상 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "damegeYn is required.")
        private Yn damegeYn;

        @ApiModelProperty(value = "클레임코드 사용유무", allowableValues = "Y, N", required = true)
        @NotNull(message = "useYn is required.")
        private Yn useYn;
    }

}
