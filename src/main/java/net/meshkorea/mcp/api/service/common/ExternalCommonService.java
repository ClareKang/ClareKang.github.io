package net.meshkorea.mcp.api.service.common;

import com.sk.api.client.poi.model.dto.PoiResultDto;
import com.sk.api.client.poi.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * Created by reverof on 2017-05-09.
 */
@Service
@DependsOn({
        "poiService"
})
public class ExternalCommonService {

    @Autowired
    private PoiService poiService;

    public PoiResultDto getAddress(String searchKeyword) throws Exception {
        return poiService.getAddress(searchKeyword);
    }

}
