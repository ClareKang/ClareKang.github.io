package net.meshkorea.mcp.api.controller.mms;

import net.meshkorea.mcp.api.config.excel.ExcelConfig;
import net.meshkorea.mcp.api.domain.model.mms.*;
import net.meshkorea.mcp.api.service.mms.MmsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public MmsListResponse sendHistories(@RequestParam(required = false) String startDate,
                                         @RequestParam(required = false) String endDate,
                                         @RequestParam(required = false) SearchOptionEnum searchOption,
                                         @RequestParam(required = false) String keyword,
                                         @RequestParam(required = false) ResultOptionEnum resultOption,
                                         @RequestParam(required = false) OrderOptionEnum orderOption,
                                         @RequestParam(required = false) Integer page,
                                         @RequestParam(required = false) Integer size) {
        MmsListRequest request = MmsListRequest.builder()
            .searchOption(searchOption)
            .keyword(keyword)
            .resultOption(resultOption)
            .orderOption(orderOption)
            .page(page)
            .size(size)
            .build();
        if (StringUtils.isNotEmpty(startDate)) {
            request.setStartDate(startDate);
        }
        if (StringUtils.isNotEmpty(endDate)) {
            request.setEndDate(endDate);
        }

        return mmsService.sendHistories(request);
    }

    @GetMapping(path = "/excel")
    public ModelAndView downloadHistories(@RequestParam(required = false) String startDate,
                                          @RequestParam(required = false) String endDate,
                                          @RequestParam(required = false) SearchOptionEnum searchOption,
                                          @RequestParam(required = false) String keyword,
                                          @RequestParam(required = false) ResultOptionEnum resultOption,
                                          @RequestParam(required = false) OrderOptionEnum orderOption,
                                          @RequestParam(required = false) Integer page,
                                          @RequestParam(required = false) Integer size,
                                          ModelAndView mav) {
        MmsListRequest request = MmsListRequest.builder()
            .searchOption(searchOption)
            .keyword(keyword)
            .resultOption(resultOption)
            .orderOption(orderOption)
            .page(page)
            .size(size)
            .build();
        if (StringUtils.isNotEmpty(startDate)) {
            request.setStartDate(startDate);
        }
        if (StringUtils.isNotEmpty(endDate)) {
            request.setEndDate(endDate);
        }

        List<String> headers = mmsService.excelHeader();
        List<List<String>> body = mmsService.excelBodies(request);

        mav.addObject(ExcelConfig.FILE_NAME, mmsService.excelFileName());
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, body);
        mav.setViewName("excelXlsxView");

        return mav;
    }

    @PostMapping(path = "/send")
    public MmsSendResponse sendMms(@RequestBody MmsSendRequest mmsSendRequest) {
        return mmsService.sendMessage(mmsSendRequest);
    }

    @PostMapping(path = "/send/excel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public MmsSendResponse sendMms(@RequestPart String message,
                                   @RequestPart(name = "excel", required = false) MultipartFile file) {
        return mmsService.sendMessage(message, file);
    }

    @GetMapping("/sample")
    public ModelAndView downloadSampleExcel(ModelAndView mav) throws Exception {
        List<String> headers = new ArrayList<>();
        headers.add("이름");
        headers.add("전화번호");
        mav.addObject(ExcelConfig.FILE_NAME, "sample");
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, Collections.EMPTY_LIST);
        mav.setViewName("excelXlsxView");
        return mav;
    }

}
