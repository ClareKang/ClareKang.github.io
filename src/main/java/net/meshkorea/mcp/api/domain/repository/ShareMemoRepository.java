package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.bookmark.ShareMemo;
import net.meshkorea.mcp.api.domain.model.bookmark.ShareMemoType;
import net.meshkorea.platform.core.web.config.data.MasterDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

@MasterDbConfig.MasterData
public interface ShareMemoRepository extends JpaSpecificationRepository<ShareMemo, Long> {
    
    ShareMemo findByShareMemoTypeAndShareMemoId(ShareMemoType shareMemoType, String shareMemoId);
}
