package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.bookmark.Bookmark;
import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkType;
import net.meshkorea.platform.core.web.config.data.MasterDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

@MasterDbConfig.MasterData
public interface BookmarkRepository extends JpaSpecificationRepository<Bookmark, Long> {
    List<Bookmark> findAllByUidAndBmkTypeAndDelYn(String uid, BookmarkType bookmarkType, char delYn, Sort sort);

    Bookmark findByUidAndBmkNo(String uid, Long bmkNo);
}
