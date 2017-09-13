package net.meshkorea.mcp.api.domain.model.bookmark;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BookmarkRequest {

    @Data
    public static class AddBookmark {
        @NotEmpty(message = "uid is required.")
        private String uid;

        @NotEmpty(message = "bmkType is required.")
        @Pattern(regexp = "DELIVERY_ORDER|ADD_ESTIMATE1|ADD_ESTIMATE2")
        private String bmkType;

        @NotEmpty(message = "bmkId is required.")
        private String bmkId;

        @NotEmpty(message = "title is required.")
        private String title;

        private String memo = "";
    }

    @Data
    public static class FindBookmark {
        @NotEmpty(message = "uid is required.")
        private String uid;

        @Pattern(regexp = "DELIVERY_ORDER|ADD_ESTIMATE1|ADD_ESTIMATE2")
        private String bmkType;
    }

    @Data
    public static class UpdateBookmark {
        @NotEmpty(message = "uid is required.")
        private String uid;

        @NotNull(message = "bmkNo is required.")
        private Long bmkNo;

        private String memo = "";
    }

    @Data
    public static class RemoveBookmark {
        @NotEmpty(message = "uid is required.")
        private String uid;

        private Long bmkNo;
    }

    @Data
    public static class RemoveBookmarkAll {
        @NotEmpty(message = "uid is required.")
        private String uid;

        @NotEmpty(message = "bmkType is required.")
        @Pattern(regexp = "DELIVERY_ORDER|ADD_ESTIMATE1|ADD_ESTIMATE2")
        private String bmkType;
    }

    @Data
    public static class GetBookmarkDetail {
        @NotEmpty(message = "uid is required.")
        private String uid;

        @NotEmpty(message = "bmkType is required.")
        @Pattern(regexp = "DELIVERY_ORDER|ADD_ESTIMATE1|ADD_ESTIMATE2")
        private String bmkType;

        @NotEmpty(message = "bmkId is required.")
        private String bmkId;
    }

}
