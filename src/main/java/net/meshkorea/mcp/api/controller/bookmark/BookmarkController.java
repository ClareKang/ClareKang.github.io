package net.meshkorea.mcp.api.controller.bookmark;

import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkRequest;
import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkResponse;
import net.meshkorea.mcp.api.error.exception.CustomBindingException;
import net.meshkorea.mcp.api.service.bookmark.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/bookmark")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("/addBookmark")
    public BookmarkResponse.AddBookmark addBookmark(@Valid @RequestBody BookmarkRequest.AddBookmark req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.AddBookmark addBookmark = new BookmarkResponse.AddBookmark();
        addBookmark.setBookmark(bookmarkService.addBookmark(req));

        return addBookmark;
    }

    @PostMapping("/findBookmarks")
    public BookmarkResponse.FindBookmark findBookmarkList(
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "bmkNo", direction = Sort.Direction.DESC)
            })
            @PageableDefault(value = 100) final Pageable pageable,
            @Valid @RequestBody BookmarkRequest.FindBookmark req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.FindBookmark findBookmark = new BookmarkResponse.FindBookmark();
        findBookmark.setBookmarkList(bookmarkService.findBookmarkList(req, pageable));

        return findBookmark;
    }

    @PutMapping("/updateBookmark")
    public BookmarkResponse.UpdateBookmark updateBookmark(@Valid @RequestBody BookmarkRequest.UpdateBookmark req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.UpdateBookmark updateBookmark = new BookmarkResponse.UpdateBookmark();
        updateBookmark.setBookmark(bookmarkService.updateBookmark(req));

        return updateBookmark;
    }

    @DeleteMapping("/removeBookmark")
    public BookmarkResponse.RemoveBookmark removeBookmark(@Valid @RequestBody BookmarkRequest.RemoveBookmark req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.RemoveBookmark removeBookmark = new BookmarkResponse.RemoveBookmark();
        removeBookmark.setBookmark(bookmarkService.removeBookmark(req));

        return removeBookmark;
    }

}
