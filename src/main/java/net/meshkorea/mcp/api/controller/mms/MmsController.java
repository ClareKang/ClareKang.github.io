package net.meshkorea.mcp.api.controller.mms;

import net.meshkorea.mcp.api.domain.model.mms.ReceiverDto;
import net.meshkorea.mcp.api.service.auth.OAuthUserService;
import net.meshkorea.mcp.api.util.excel.ExcelReadComponent;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@RestController
@RequestMapping("/v1/mms")
public class MmsController {

    @Autowired
    private ExcelReadComponent excelReadComponent;

    @Autowired
    private OAuthUserService userService;

    @GetMapping("/token")
    public void mmsToken() {
        userService.getCurrentUser();
    }

    @PostMapping("/excel")
    public List<ReceiverDto> uploadExcel(@RequestParam("file") MultipartFile multipartFile)
        throws IOException, InvalidFormatException {
        return excelReadComponent.readExcelToList(multipartFile, ReceiverDto::rowOf);
    }

    @GetMapping("/excel")
    public void downloadExcel() {

    }
}
