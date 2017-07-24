package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
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

}
