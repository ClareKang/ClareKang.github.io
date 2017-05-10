package net.meshkorea.mcp.api.service.address;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.ExtraFeeAddressList;
import com.meshprime.intra.api.IntraAddressesApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungjae.hong on 2017. 5. 4..
 */
@Service
public class RegionsService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraAddressesApi intraAddressesApi;


    public ExtraFeeAddressList getSidoList(String sido) throws ApiException {
        return intraAddressesApi.listSiDo(intraTokenService.getAuthToken(), sido);
    }

    public ExtraFeeAddressList getSiGunGuList(String sido, String sigungu) throws ApiException {
        return intraAddressesApi.listSiGunGu(intraTokenService.getAuthToken(), sido, sigungu);
    }

}
