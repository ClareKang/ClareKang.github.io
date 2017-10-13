package net.meshkorea.mcp.api.domain.model.bookmark;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BookmarkRequest {

    @Data
    public static class AddBookmark {
        @NotEmpty(message = "email is required.")
        private String email;

        @NotEmpty(message = "bmkType is required.")
        @Pattern(regexp = "DELIVERY_ORDER|ADD_ESTIMATE1|ADD_ESTIMATE2")
        private String bmkType;

        @NotEmpty(message = "bmkId is required.")
        private String bmkId;

        @NotEmpty(message = "title is required.")
        private String title;

        private String memo = "";

        @NotEmpty(message = "delYn is required.")
        @Pattern(regexp = "Y|N")
        private String delYn;
    }

    @Data
    public static class FindBookmark {
        @NotEmpty(message = "email is required.")
        private String email;

        @Pattern(regexp = "DELIVERY_ORDER|ADD_ESTIMATE1|ADD_ESTIMATE2")
        private String bmkType;
    }

    @Data
    public static class UpdateBookmark {
        @NotEmpty(message = "email is required.")
        private String email;

        @NotNull(message = "bmkNo is required.")
        private Long bmkNo;

        private String memo;

        @NotEmpty(message = "delYn is required.")
        @Pattern(regexp = "Y|N")
        private String delYn;
    }

    @Data
    public static class RemoveBookmark {
        @NotEmpty(message = "email is required.")
        private String email;

        private Long bmkNo;
    }

    @Data
    public static class RemoveBookmarkAll {
        @NotEmpty(message = "email is required.")
        private String email;

        @NotEmpty(message = "bmkType is required.")
        @Pattern(regexp = "DELIVERY_ORDER|ADD_ESTIMATE1|ADD_ESTIMATE2")
        private String bmkType;
    }

    @Data
    public static class GetBookmarkDetail {
        @NotEmpty(message = "email is required.")
        private String email;

        @NotEmpty(message = "bmkType is required.")
        @Pattern(regexp = "DELIVERY_ORDER|ADD_ESTIMATE1|ADD_ESTIMATE2")
        private String bmkType;

        @NotEmpty(message = "bmkId is required.")
        private String bmkId;
    }

}
