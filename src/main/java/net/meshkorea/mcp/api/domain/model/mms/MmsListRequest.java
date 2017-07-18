package net.meshkorea.mcp.api.domain.model.mms;

import lombok.*;
import net.meshkorea.mcp.api.domain.model.common.BaseRequest;
import net.meshkorea.mcp.api.domain.model.common.PageableRequest;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by reverof on 2017-07-17.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MmsListRequest extends BaseRequest implements PageableRequest {

    @Getter
    private LocalDateTime startDate;

    @Getter
    private LocalDateTime endDate;

    @Getter
    @Setter
    private SearchOptionEnum searchOption;

    @Getter
    @Setter
    private String keyword;

    @Getter
    @Setter
    private ResultOptionEnum resultOption;

    @Getter
    @Setter
    private OrderOptionEnum orderOption;

    @Getter
    @Setter
    private Integer page;

    @Getter
    @Setter
    private Integer size;

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(String startDate) {
        if (StringUtils.isNotEmpty(startDate)) {
            this.startDate = LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(String endDate) {
        if (StringUtils.isNotEmpty(endDate)) {
            this.endDate = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }

}
