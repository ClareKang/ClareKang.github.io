package net.meshkorea.mcp.api.service.claim;

import net.meshkorea.mcp.api.entity.claim.Claim;
import net.meshkorea.mcp.api.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by reverof on 2017. 3. 24..
 */
@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Transactional
    public void addClaim(Claim claim) {
        claimRepository.save(claim);
    }

    @Transactional
    public Claim getClaim(Claim claim) {
        return claimRepository.getOne(claim.getClaimNo());
    }

    @Transactional
    public Claim getClaim(Long claimNo) {
        return claimRepository.getOne(claimNo);
    }

    @Transactional
    public void removeClaim(Claim claim) {
        claimRepository.delete(claim.getClaimNo());
    }

    @Transactional
    public void removeClaim(Long claimNo) {
        claimRepository.delete(claimNo);
    }
}
