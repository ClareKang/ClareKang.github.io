package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@Builder
public class ReceiverDto {

    @Setter
    private String name;

    @Getter
    @Setter
    private String phone;

    public String getName() {
        if (this.name != null) {
            return this.name;
        }
        return StringUtils.EMPTY;
    }

}
