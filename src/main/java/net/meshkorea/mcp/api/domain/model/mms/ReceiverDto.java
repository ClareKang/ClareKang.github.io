package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@Getter
@Setter
@Builder
public class ReceiverDto {

    private String name;

    private String phone;

    /**
     * for Excel
     *
     * @param row
     * @return
     */
    public static ReceiverDto rowOf(Row row) {
        return ReceiverDto.builder()
            .name(row.getCell(0).getStringCellValue())
            .phone(row.getCell(1).getStringCellValue())
            .build();
    }

}
