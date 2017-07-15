package net.meshkorea.mcp.api.controller.mms;

import net.meshkorea.mcp.api.domain.model.mms.MmsSendRequest;
import net.meshkorea.mcp.api.domain.model.mms.MmsSendResponse;
import net.meshkorea.mcp.api.service.mms.MmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@RestController
@RequestMapping("/v1/mms")
public class MmsController {

    @Autowired
    private MmsService mmsService;

    @PostMapping(path = "/send", consumes = {"multipart/form-data"})
    public MmsSendResponse sendMms(@RequestPart MmsSendRequest mmsSendRequest,
                                   @RequestPart(name = "excel", required = false) MultipartFile file) {
        return mmsService.sendMessage(mmsSendRequest, file);
    }

    // @PostMapping(path = "/send", consumes = {"multipart/form-data"})
    public MmsSendResponse sendMms(@RequestPart String message,
                                   @RequestPart(name = "excel", required = false) MultipartFile file) {
        return mmsService.sendMessage(message, file);
    }

}
