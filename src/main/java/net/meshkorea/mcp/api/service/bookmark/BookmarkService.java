package net.meshkorea.mcp.api.service.bookmark;

import net.meshkorea.mcp.api.domain.entity.bookmark.Bookmark;
import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkRequest;
import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkType;
import net.meshkorea.mcp.api.domain.repository.BookmarkRepository;
import org.apache.commons.lang3.StringUtils;
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
        bookmark.setEmail(req.getEmail());
        bookmark.setBmkId(req.getBmkId());
        bookmark.setBmkType(BookmarkType.valueOf(req.getBmkType()));
        bookmark.setTitle(req.getTitle());
        bookmark.setMemo(req.getMemo());
        bookmark.setCreateDt(new Date());
        bookmark.setIssueDt(new Date());
        bookmark.setDelYn(req.getDelYn().charAt(0));

        return bookmarkRepository.save(bookmark);
    }

    public List<Bookmark> findBookmarkList(BookmarkRequest.FindBookmark req, Pageable pageable) {
        // query hint : email + bmkType
        if (StringUtils.isEmpty(req.getBmkType()) == false) {
            return bookmarkRepository.findAllByEmailAndBmkTypeAndDelYn(req.getEmail(), BookmarkType.valueOf(req.getBmkType()), 'N', pageable.getSort());
        }

        // query hint : email
        return bookmarkRepository.findAllByEmailAndDelYn(req.getEmail(), 'N', pageable.getSort());

    }

    public Bookmark updateBookmark(BookmarkRequest.UpdateBookmark req) {
        Bookmark bookmark = bookmarkRepository.findByEmailAndBmkNo(req.getEmail(), req.getBmkNo());

        if (req.getMemo() != null) {
            bookmark.setMemo(req.getMemo());
        }

        bookmark.setIssueDt(new Date());
        bookmark.setDelYn('N');

        return bookmarkRepository.save(bookmark);
    }

    public Bookmark removeBookmark(BookmarkRequest.RemoveBookmark req) {
        Bookmark bookmark = bookmarkRepository.findByEmailAndBmkNo(req.getEmail(), req.getBmkNo());
        bookmark.setDelYn('Y');
        bookmark.setIssueDt(new Date());

        return bookmarkRepository.save(bookmark);
    }

    public boolean removeBookmarkAll(BookmarkRequest.RemoveBookmarkAll req) {
        bookmarkRepository.updateBulkDelYn(req.getEmail(), BookmarkType.valueOf(req.getBmkType()), 'Y', new Date());

        return true;
    }

    public Long getBookmarkCount(BookmarkRequest.FindBookmark req) {
        // query hint : email + bmkType
        if (StringUtils.isEmpty(req.getBmkType()) == false) {
            return bookmarkRepository.countByEmailAndBmkTypeAndDelYn(req.getEmail(), BookmarkType.valueOf(req.getBmkType()), 'N');
        }

        // query hint : email
        return bookmarkRepository.countByEmailAndDelYn(req.getEmail(), 'N');
    }

    public Bookmark getBookmarkDetail(BookmarkRequest.GetBookmarkDetail req) {
        return bookmarkRepository.findByEmailAndBmkTypeAndBmkId(req.getEmail(), BookmarkType.valueOf(req.getBmkType()), req.getBmkId());
    }
}
