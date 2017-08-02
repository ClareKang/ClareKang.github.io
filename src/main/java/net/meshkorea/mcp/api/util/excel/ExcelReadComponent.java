package net.meshkorea.mcp.api.util.excel;

import net.meshkorea.mcp.api.domain.model.mms.ExcelExtensionEnum;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ExcelReadComponent {

    public <T> List<T> readExcelToList(final MultipartFile multipartFile,
                                       final Function<Row, T> rowFunc,
                                       final Integer start) throws IOException, InvalidFormatException {

        final Workbook workbook = readWorkbook(multipartFile);
        final Sheet sheet = workbook.getSheetAt(0); // first sheet
        int rowCount = Math.max(sheet.getPhysicalNumberOfRows(), sheet.getLastRowNum() + 1);

        return IntStream
            .range(start, rowCount)
            .mapToObj(rowIndex -> rowFunc.apply(sheet.getRow(rowIndex)))
            .collect(Collectors.toList());
    }

    public <T> List<T> readExcelToList(final MultipartFile multipartFile,
                                       final Function<Row, T> rowFunc) throws IOException, InvalidFormatException {

        return readExcelToList(multipartFile, rowFunc, 0);
    }

    private Workbook readWorkbook(MultipartFile multipartFile) throws IOException, InvalidFormatException {
        verifyFileExtension(multipartFile);
        return multipartFileToWorkbook(multipartFile);
    }

    private void verifyFileExtension(MultipartFile multipartFile) throws InvalidFormatException {
        if (!isExcelExtension(multipartFile.getOriginalFilename())) {
            throw new InvalidFormatException("This file extension is not verify");
        }
    }

    private boolean isExcelExtension(String fileName) {
        return isExcelXls(fileName) || isExcelXlsx(fileName);
    }

    private boolean isExcelXls(String fileName) {
        return fileName.endsWith(ExcelExtensionEnum.XLS.getValue());
    }

    private boolean isExcelXlsx(String fileName) {
        return fileName.endsWith(ExcelExtensionEnum.XLSX.getValue());
    }

    private Workbook multipartFileToWorkbook(MultipartFile multipartFile) throws IOException {
        if (isExcelXls(multipartFile.getOriginalFilename())) {
            return new HSSFWorkbook(multipartFile.getInputStream());
        } else {
            return new XSSFWorkbook(multipartFile.getInputStream());
        }
    }
}
