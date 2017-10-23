package net.meshkorea.mcp.api.service.bookmark;

import net.meshkorea.mcp.api.domain.entity.bookmark.ShareMemo;
import net.meshkorea.mcp.api.domain.model.bookmark.ShareMemoRequest;
import net.meshkorea.mcp.api.domain.model.bookmark.ShareMemoType;
import net.meshkorea.mcp.api.domain.repository.ShareMemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShareMemoService {

    @Autowired
    private ShareMemoRepository shareMemoRepository;

    public ShareMemo saveMemo(ShareMemoRequest.SaveMemo req) {
        // 이미 저장된 메모
        ShareMemo memo = shareMemoRepository.findByShareMemoTypeAndShareMemoId(ShareMemoType.valueOf(req.getShareMemoType()), req.getShareMemoId());

        // 신규 메모
        if (memo == null) {
            memo = new ShareMemo();
        }

        memo.setIssueDt(new Date());
        memo.setIssuor(req.getEmail());
        memo.setShareMemo(req.getShareMemo());
        memo.setShareMemoId(req.getShareMemoId());
        memo.setShareMemoType(ShareMemoType.valueOf(req.getShareMemoType()));

        return shareMemoRepository.save(memo);
    }

    public ShareMemo findMemo(ShareMemoRequest.FindMemo req) {
        ShareMemo memo = shareMemoRepository.findByShareMemoTypeAndShareMemoId(ShareMemoType.valueOf(req.getShareMemoType()), req.getShareMemoId());
        return memo;
    }
}
