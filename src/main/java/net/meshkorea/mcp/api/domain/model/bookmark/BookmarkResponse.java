package net.meshkorea.mcp.api.domain.model.bookmark;

import lombok.Data;
import net.meshkorea.mcp.api.domain.entity.bookmark.Bookmark;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;

import java.util.List;

public class BookmarkResponse {

    @Data
    public static class AddBookmark extends BaseResponse {
        private Bookmark bookmark;
    }

    @Data
    public static class FindBookmark extends BaseResponse {
        private List<Bookmark> bookmarkList;
    }

    @Data
    public static class UpdateBookmark extends BaseResponse {
        private Bookmark bookmark;
    }

    @Data
    public static class RemoveBookmark extends BaseResponse {
        private Bookmark bookmark;
    }

    @Data
    public static class Result extends BaseResponse {
        private boolean isDone;
    }

    @Data
    public static class CountBookmark extends BaseResponse {
        private Long count;
        private String bmkType;
    }

    @Data
    public static class GetBookmarkDetail extends BaseResponse {
        private Bookmark bookmark;
    }

}
