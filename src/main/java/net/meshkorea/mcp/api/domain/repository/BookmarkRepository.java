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
    List<Bookmark> findAllByEmailAndBmkTypeAndDelYn(String email, BookmarkType bookmarkType, char delYn, Sort sort);

    Bookmark findByEmailAndBmkNo(String email, Long bmkNo);

    List<Bookmark> findAllByEmailAndDelYn(String email, char delYn, Sort sort);

    @Modifying
    @Transactional
    @Query("UPDATE Bookmark SET delYn = :delYn, issueDt = :issueDt WHERE email = :email AND bmkType = :bookmarkType")
    void updateBulkDelYn(@Param("email") String email,
                         @Param("bookmarkType") BookmarkType bookmarkType,
                         @Param("delYn") char delYn,
                         @Param("issueDt") Date issueDt);

    Long countByEmailAndBmkTypeAndDelYn(String email, BookmarkType bookmarkType, char delYn);

    Long countByEmailAndDelYn(String email, char delYn);

    Bookmark findByEmailAndBmkTypeAndBmkId(String email, BookmarkType bookmarkType, String bmkId);
}
