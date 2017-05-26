package net.meshkorea.mcp.api.service.fee;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.ExtraFee;
import com.meshprime.api.client.model.ExtraFeeRequest;
import com.meshprime.api.client.model.ExtraFeeResponse;
import com.meshprime.intra.api.IntraExtraFeesApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungjae.hong on 2017. 4. 24..
 */
@Service
public class ExtraFeeService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraExtraFeesApi intraExtraFeesApi;

    public ExtraFeeResponse findExtraFees(String keyword, int page) throws ApiException{
        return intraExtraFeesApi.listExtraFees(intraTokenService.getAuthToken(), keyword, page);
    }

    public ExtraFee findExtraFeeById(int id) throws ApiException{
        ExtraFee extraFee = new ExtraFee();
        extraFee = intraExtraFeesApi.getExtraFee(intraTokenService.getAuthToken(), id);
        logger.info(extraFee.toString());
        return extraFee;
    }

    public ExtraFee clearTargetStore(int id) throws ApiException{
        System.out.println("id :" + id);
        return intraExtraFeesApi.clearTargetStores(intraTokenService.getAuthToken(), id);
    }

    public ExtraFee createExtraFee(ExtraFeeRequest extraFeeRequest) throws ApiException{
        return intraExtraFeesApi.createExtraFee(intraTokenService.getAuthToken(), extraFeeRequest);
    }

    public ExtraFee updateExtraFee(ExtraFeeRequest extraFeeRequest, int id) throws ApiException {
        return intraExtraFeesApi.updateExtraFee(intraTokenService.getAuthToken(), id, extraFeeRequest);
    }
}
