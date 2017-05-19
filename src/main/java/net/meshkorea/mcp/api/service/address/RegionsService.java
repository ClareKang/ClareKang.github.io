package net.meshkorea.mcp.api.service.address;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.ExtraFeeAddressList;
import com.meshprime.intra.api.IntraAddressesApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungjae.hong on 2017. 5. 4..
 */
@Service
public class RegionsService {

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

    public ExtraFeeAddressList getLegalDongList(String sido, String sigungu, String keyword) throws ApiException {
        return intraAddressesApi.listLegalDong(intraTokenService.getAuthToken(), sido, sigungu, keyword);
    }

    public ExtraFeeAddressList getAdminDongList(String sido, String sigungu, String keyword) throws ApiException {
        return intraAddressesApi.listAdminDong(intraTokenService.getAuthToken(), sido, sigungu, keyword);
    }

    public ExtraFeeAddressList getAddressList(String sido, String sigungu, String keyword, String page, String size) throws ApiException {
        return intraAddressesApi.listAddress(intraTokenService.getAuthToken(), sido, sigungu, keyword, page, size);
    }

}
