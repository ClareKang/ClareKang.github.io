package net.meshkorea.mcp.api.controller.mms;

import net.meshkorea.mcp.api.domain.model.mms.MmsSendRequest;
import net.meshkorea.mcp.api.domain.model.mms.MmsSendResponse;
import net.meshkorea.mcp.api.service.mms.MmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@RestController
@RequestMapping("/v1/mms")
public class MmsController {

    @Autowired
    private MmsService mmsService;

    @PostMapping("/send")
    public MmsSendResponse sendMms(@RequestBody MmsSendRequest mmsSendRequest, @RequestPart(required = false) MultipartFile multipartFile) {
        return mmsService.sendMessage(mmsSendRequest, multipartFile);
    }

}
