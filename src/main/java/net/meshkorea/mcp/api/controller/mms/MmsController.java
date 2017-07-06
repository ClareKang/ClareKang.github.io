package net.meshkorea.mcp.api.controller.mms;

import net.meshkorea.mcp.api.domain.model.mms.ReceiverDto;
import net.meshkorea.mcp.api.util.excel.ExcelReadComponent;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/excel")
    public List<ReceiverDto> readExcel(@RequestParam("file") MultipartFile multipartFile)
        throws IOException, InvalidFormatException {
        return excelReadComponent.readExcelToList(multipartFile, ReceiverDto::rowOf);
    }
}
