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

}
