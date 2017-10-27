package net.meshkorea.mcp.api.domain.model.bookmark;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.bookmark.Bookmark;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;

import java.util.List;

public class BookmarkResponse {

    @Getter
    @Setter
    public static class AddBookmark extends BaseResponse {
        private Bookmark bookmark;
    }

    @Getter
    @Setter
    public static class FindBookmark extends BaseResponse {
        private List<Bookmark> bookmarkList;
    }

    @Getter
    @Setter
    public static class UpdateBookmark extends BaseResponse {
        private Bookmark bookmark;
    }

    @Getter
    @Setter
    public static class RemoveBookmark extends BaseResponse {
        private Bookmark bookmark;
    }

    @Getter
    @Setter
    public static class Result extends BaseResponse {
        private boolean isDone;
    }

    @Getter
    @Setter
    public static class CountBookmark extends BaseResponse {
        private Long count;
        private String bmkType;
    }

    @Getter
    @Setter
    public static class GetBookmarkDetail extends BaseResponse {
        private Bookmark bookmark;
    }

}
