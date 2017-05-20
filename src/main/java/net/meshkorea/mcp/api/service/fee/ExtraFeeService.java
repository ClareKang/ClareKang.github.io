package net.meshkorea.mcp.api.service.fee;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.ExtraFee;
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

    public void clearTargetStore(int id) throws ApiException{
        System.out.println("id :" + id);
        intraExtraFeesApi.clearTargetStores(intraTokenService.getAuthToken(), id);
    }
}
