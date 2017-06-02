package net.meshkorea.mcp.api.service.claim;

import net.meshkorea.mcp.api.domain.model.claim.ClaimDto;
import net.meshkorea.mcp.api.domain.entity.claim.Claim;
import net.meshkorea.mcp.api.domain.entity.claim.ClaimHistory;
import net.meshkorea.mcp.api.domain.repository.ClaimHistoryRepository;
import net.meshkorea.mcp.api.domain.repository.ClaimRepository;
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
    private ClaimRepository claimHistory;

    @Autowired
    private ClaimHistoryRepository claimHistoryRepository;

    public Page<ClaimHistory> getList(Pageable pageable) {
        return claimHistoryRepository.findAll(pageable);
    }

    public void addClaimHistoryFromClaim(Claim prevClaimInfo) {
        ClaimDto claimDto = new ClaimDto().from(prevClaimInfo);
    }

    private void convertToJsonString(ClaimDto claimDto) {

    }
}
