package net.meshkorea.mcp.api.controller.bookmark;

import net.meshkorea.mcp.api.domain.model.bookmark.ShareMemoRequest;
import net.meshkorea.mcp.api.domain.model.bookmark.ShareMemoResponse;
import net.meshkorea.mcp.api.error.exception.CustomBindingException;
import net.meshkorea.mcp.api.service.bookmark.ShareMemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/share-memo")
public class ShareMemoController {

    @Autowired
    private ShareMemoService memoService;

    @PostMapping("/saveMemo")
    public ShareMemoResponse.SaveMemo saveMemo(@Valid @RequestBody ShareMemoRequest.SaveMemo req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        ShareMemoResponse.SaveMemo saveMemo = new ShareMemoResponse.SaveMemo();
        saveMemo.setShareMemo(memoService.saveMemo(req));

        return saveMemo;
    }

    @PostMapping("/findMemo")
    public ShareMemoResponse.FindMemo findBookmarkList(@Valid @RequestBody ShareMemoRequest.FindMemo req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        ShareMemoResponse.FindMemo findeMemo = new ShareMemoResponse.FindMemo();
        findeMemo.setShareMemo(memoService.findMemo(req));

        return findeMemo;
    }
}
