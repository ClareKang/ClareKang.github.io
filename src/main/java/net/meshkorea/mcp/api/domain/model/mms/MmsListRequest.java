package net.meshkorea.mcp.api.domain.model.mms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseRequest;
import net.meshkorea.mcp.api.domain.model.common.PageableRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by reverof on 2017-07-17.
 */
@NoArgsConstructor
@AllArgsConstructor
public class MmsListRequest extends BaseRequest implements PageableRequest {

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
        this.startDate = LocalDateTime.parse(startDate, dateFormatter);
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = LocalDateTime.parse(endDate, dateFormatter);
    }

}
