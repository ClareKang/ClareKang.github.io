package net.meshkorea.mcp.api.service.notice;

import com.meshprime.api.client.model.StoreNotice;
import com.meshprime.api.client.model.StoreNoticeRequest;
import com.meshprime.intra.api.IntraStoreNoticeApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by clare on 12/4/17.
 */
@Service
@DependsOn({
        "fileSystemStorageService"
})
public class StoreNoticeService {

    @Autowired
    private IntraTokenService intraTokenService;

    @Autowired
    private IntraStoreNoticeApi intraStoreNoticeApi;

    // 공지 목록
    public List<StoreNotice> listStoreNotices(
            String startTime,
            String endTime,
            String title,
            String message,
            Integer page,
            Integer size
    ) throws Exception {
        return intraStoreNoticeApi.listStoreNotices(
                intraTokenService.getAuthToken(),
                startTime,
                endTime,
                title,
                message,
                page,
                size
        );
    }

    // 공지 상세
    public StoreNotice getStoreNotice(Integer id) throws Exception {
        return intraStoreNoticeApi.getStoreNotice(intraTokenService.getAuthToken(), id);
    }

    // 공지 등록
    public StoreNotice createStoreNotice(StoreNoticeRequest req) throws Exception {
        return intraStoreNoticeApi.createStoreNotice(intraTokenService.getAuthToken(), req);
    }

    // 공지 수정
    public StoreNotice updateStoreNotice(Integer id, StoreNoticeRequest req) throws Exception {
        return intraStoreNoticeApi.updateStoreNotice(intraTokenService.getAuthToken(), id, req);
    }

    // 공지 삭제
    public void deleteStoreNotice(Integer id) throws Exception {
        intraStoreNoticeApi.deleteStoreNotice(intraTokenService.getAuthToken(), id);
    }

}
