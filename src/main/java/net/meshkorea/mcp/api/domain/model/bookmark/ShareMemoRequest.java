package net.meshkorea.mcp.api.domain.model.bookmark;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ShareMemoRequest {

    @Data
    public static class SaveMemo {
        @NotEmpty(message = "shareMemoType is required.")
        @Pattern(regexp = "DELIVERY_ORDER|ADD_ESTIMATE1|ADD_ESTIMATE2")
        private String shareMemoType;

        @NotEmpty(message = "shareMemoId is required.")
        private String shareMemoId;

        @NotNull
        private String shareMemo;

        @NotEmpty(message = "email is required.")
        private String email;
    }

    @Data
    public static class FindMemo {
        @NotEmpty(message = "shareMemoType is required.")
        @Pattern(regexp = "DELIVERY_ORDER|ADD_ESTIMATE1|ADD_ESTIMATE2")
        private String shareMemoType;

        @NotEmpty(message = "shareMemoId is required.")
        private String shareMemoId;
    }
}
