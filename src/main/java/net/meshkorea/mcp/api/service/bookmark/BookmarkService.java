package net.meshkorea.mcp.api.service.bookmark;

import net.meshkorea.mcp.api.domain.entity.bookmark.Bookmark;
import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkRequest;
import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkType;
import net.meshkorea.mcp.api.domain.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    public Bookmark addBookmark(BookmarkRequest.AddBookmark req) {
        Bookmark bookmark = new Bookmark();
        bookmark.setUid(req.getUid());
        bookmark.setBmkId(req.getBmkId());
        bookmark.setBmkType(BookmarkType.valueOf(req.getBmkType()));
        bookmark.setTitle(req.getTitle());
        bookmark.setMemo(req.getMemo());
        bookmark.setCreateDt(new Date());
        bookmark.setIssueDt(new Date());
        bookmark.setDelYn('N');

        return bookmarkRepository.save(bookmark);
    }

    public List<Bookmark> findBookmarkList(BookmarkRequest.FindBookmark req, Pageable pageable) {
        return bookmarkRepository.findAllByUidAndBmkTypeAndDelYn(req.getUid(), BookmarkType.valueOf(req.getBmkType()), 'N', pageable.getSort());
    }

    public Bookmark updateBookmark(BookmarkRequest.UpdateBookmark req) {
        Bookmark bookmark = bookmarkRepository.findByUidAndBmkNo(req.getUid(), req.getBmkNo());
        bookmark.setMemo(req.getMemo());
        bookmark.setIssueDt(new Date());

        return bookmarkRepository.save(bookmark);
    }

    public Bookmark removeBookmark(BookmarkRequest.RemoveBookmark req) {
        Bookmark bookmark = bookmarkRepository.findByUidAndBmkNo(req.getUid(), req.getBmkNo());
        bookmark.setDelYn('Y');
        bookmark.setIssueDt(new Date());

        return bookmarkRepository.save(bookmark);
    }
}
