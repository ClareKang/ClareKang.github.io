package net.meshkorea.mcp.api.domain.model.mms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MmsSendRequest extends BaseRequest {

    private String message;

    private List<ReceiverDto> receivers = new ArrayList<>();

    public MmsSendRequest(String message) {
        this.message = message;
    }

}
