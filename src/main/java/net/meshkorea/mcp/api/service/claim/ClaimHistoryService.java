package net.meshkorea.mcp.api.service.claim;

import net.meshkorea.mcp.api.entity.claim.ClaimHistory;
import net.meshkorea.mcp.api.repository.ClaimHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by reverof on 2017. 4. 10..
 */
@Service
public class ClaimHistoryService {

    @Autowired
    private ClaimHistoryRepository claimHistoryRepository;

    public Page<ClaimHistory> getList(Pageable pageable) {
        return claimHistoryRepository.findAll(pageable);
    }
}
