package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.bookmark.Bookmark;
import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkType;
import net.meshkorea.platform.core.web.config.data.MasterDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@MasterDbConfig.MasterData
public interface BookmarkRepository extends JpaSpecificationRepository<Bookmark, Long> {
    List<Bookmark> findAllByUidAndBmkTypeAndDelYn(String uid, BookmarkType bookmarkType, char delYn, Sort sort);

    Bookmark findByUidAndBmkNo(String uid, Long bmkNo);

    List<Bookmark> findAllByUidAndDelYn(String uid, char delYn, Sort sort);

    @Modifying
    @Transactional
    @Query("UPDATE Bookmark SET delYn = :delYn, issueDt = :issueDt WHERE uid = :uid AND bmkType = :bookmarkType")
    void updateBulkDelYn(@Param("uid") String uid,
                         @Param("bookmarkType") BookmarkType bookmarkType,
                         @Param("delYn") char delYn,
                         @Param("issueDt") Date issueDt);
}
