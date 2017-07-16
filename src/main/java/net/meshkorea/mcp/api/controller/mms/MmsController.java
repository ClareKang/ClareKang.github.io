package net.meshkorea.mcp.api.controller.mms;

import net.meshkorea.mcp.api.config.excel.ExcelConfig;
import net.meshkorea.mcp.api.domain.model.mms.MmsSendRequest;
import net.meshkorea.mcp.api.domain.model.mms.MmsSendResponse;
import net.meshkorea.mcp.api.service.mms.MmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@RestController
@RequestMapping("/v1/mms")
public class MmsController {

    @Autowired
    private MmsService mmsService;

    @GetMapping
    public void list() {

    }

    @PostMapping(path = "/send")
    public MmsSendResponse sendMms(@RequestBody MmsSendRequest mmsSendRequest) {
        return mmsService.sendMessage(mmsSendRequest);
    }

    @PostMapping(path = "/send/excel", consumes = {"multipart/form-data"})
    public MmsSendResponse sendMms(@RequestPart String message,
                                   @RequestPart(name = "excel", required = false) MultipartFile file) {
        return mmsService.sendMessage(message, file);
    }

    @GetMapping("/sample")
    public ModelAndView downloadSampleExcel(ModelAndView mav) throws Exception {
        List<String> headers = new ArrayList<>();
        headers.add("이름");
        headers.add("전화번호");
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, Collections.EMPTY_LIST);
        mav.setViewName("excelXlsxView");
        return mav;
    }

}
