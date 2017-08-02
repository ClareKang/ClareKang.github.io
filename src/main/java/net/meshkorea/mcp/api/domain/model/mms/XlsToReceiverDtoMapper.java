package net.meshkorea.mcp.api.domain.model.mms;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class XlsToReceiverDtoMapper {

    public static Integer NAME_COLUMN_INDEX = 0;
    public static Integer PHONE_COLUMN_INDEX = 1;

    public static String PHONE_NUMBER_EXCLUDE_PATTERN = "[\\D]+";

    public static ReceiverDto rowOf(Row row) {
        String name = StringUtils.EMPTY;
        String phone = StringUtils.EMPTY;
        if (row != null) {
            name = XlsToReceiverDtoMapper.getStringValue(row.getCell(NAME_COLUMN_INDEX));
            phone = XlsToReceiverDtoMapper.getStringValue(row.getCell(PHONE_COLUMN_INDEX));
            if (XlsToReceiverDtoMapper.isExcludePattern(XlsToReceiverDtoMapper.excludeDash(phone))) {
                throw new NumberFormatException();
            }
        }
        return ReceiverDto.builder()
            .name(name)
            .phone(phone)
            .build();
    }

    public static String excludeDash(String phoneNumber) {
        if (StringUtils.isNotEmpty(phoneNumber)) {
            return phoneNumber.replaceAll("-", StringUtils.EMPTY);
        }
        return phoneNumber;
    }

    public static boolean isExcludePattern(String phoneNumber) {
        if (StringUtils.isNotEmpty(phoneNumber)) {
            return phoneNumber.matches(PHONE_NUMBER_EXCLUDE_PATTERN);
        }
        return false;
    }

    private static String getStringValue(Cell cell) {
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    return String.valueOf(Math.round(cell.getNumericCellValue()));
                case STRING:
                    return cell.getStringCellValue();
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                default:
                    return StringUtils.EMPTY;
            }
        }
        return StringUtils.EMPTY;
    }
}
