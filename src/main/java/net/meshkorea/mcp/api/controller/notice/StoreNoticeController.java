package net.meshkorea.mcp.api.controller.notice;

import com.meshprime.api.client.model.StoreNotice;
import com.meshprime.api.client.model.StoreNoticeRequest;
import net.meshkorea.mcp.api.service.notice.StoreNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by clare on 12/4/17.
 */
@RestController
@RequestMapping(value = "/v1/intra/notices")
public class StoreNoticeController {
    @Autowired
    private StoreNoticeService storeNoticeService;

    /**
     * 공지 목록
     *
     * @param startTime
     * @param endTime
     * @param title
     * @param message
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping
    public List<StoreNotice> listStoreNotices(
            @RequestParam(required = false) String startTime,
            @RequestParam(required = false) String endTime,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String message,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) throws Exception {
        return storeNoticeService.listStoreNotices(
                startTime,
                endTime,
                title,
                message,
                page,
                size
        );
    }

    /**
     * 공지 상세
     *
     * @param noticeId
     * @return
     * @throws Exception
     */
    @GetMapping("/{noticeId}")
    public StoreNotice getStoreNotice(@PathVariable Integer noticeId) throws Exception {
        return storeNoticeService.getStoreNotice(noticeId);
    }


    /**
     * 공지 등록
     *
     * @param req
     * @return
     * @throws Exception
     */
    @PostMapping
    public StoreNotice createStoreNotice(@RequestBody StoreNoticeRequest req) throws Exception {
        return storeNoticeService.createStoreNotice(req);
    }

    /**
     * 공지 수정
     *
     * @param noticeId
     * @param req
     * @return
     * @throws Exception
     */
    @PutMapping("/{noticeId}")
    public StoreNotice updateStoreNotice(
            @PathVariable Integer noticeId,
            @RequestBody StoreNoticeRequest req
    ) throws Exception {
        return storeNoticeService.updateStoreNotice(noticeId, req);
    }

    /**
     * 공지 삭제
     *
     * @param noticeId
     * @throws Exception
     */
    @DeleteMapping("/{noticeId}")
    public void deleteStoreNotice(@PathVariable Integer noticeId) throws Exception {
        storeNoticeService.deleteStoreNotice(noticeId);
    }

}
