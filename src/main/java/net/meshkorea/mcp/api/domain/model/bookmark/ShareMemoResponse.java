package net.meshkorea.mcp.api.domain.model.bookmark;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.bookmark.ShareMemo;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;

public class ShareMemoResponse {

    @Getter
    @Setter
    public static class SaveMemo extends BaseResponse {
        private ShareMemo shareMemo;
    }

    @Getter
    @Setter
    public static class FindMemo extends BaseResponse {
        private ShareMemo shareMemo;
    }
}
