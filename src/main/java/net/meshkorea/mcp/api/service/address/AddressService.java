package net.meshkorea.mcp.api.service.address;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.ExtraFeeAddressList;
import com.meshprime.intra.api.IntraAddressesApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jinho.kim on 2017. 10. 25..
 */
@Service
public class AddressService {

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

    public ExtraFeeAddressList getLegalRiList(String sido, String sigungu, String legalDong, String keyword) throws ApiException {
        return intraAddressesApi.listLegalRi(intraTokenService.getAuthToken(), sido, sigungu, legalDong, keyword);
    }

    public ExtraFeeAddressList getSearchList(String sido, String sigungu, String legalDong, String legalRi, String addressType, String keyword, String page, String size) throws ApiException {
        return intraAddressesApi.listSearch(intraTokenService.getAuthToken(), sido, sigungu, legalDong, legalRi, addressType, keyword, Integer.valueOf(page), Integer.valueOf(size));
    }

}
