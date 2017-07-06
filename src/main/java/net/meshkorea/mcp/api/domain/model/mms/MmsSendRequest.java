package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseRequest;

import java.util.List;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@Getter
@Setter
public class MmsSendRequest extends BaseRequest {

    private String message;

    private List<ReceiverDto> receivers;

}
