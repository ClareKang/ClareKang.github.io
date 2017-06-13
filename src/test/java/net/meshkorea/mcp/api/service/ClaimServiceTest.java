package net.meshkorea.mcp.api.service;

import net.meshkorea.mcp.api.service.claim.ClaimService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by reverof on 2017. 4. 10..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClaimServiceTest {

    @Autowired
    private ClaimService claimService;

    private String STATUS_CODE = "TEST_STATUS";

//    @Test
//    public void 클레임_등록_조회_삭제() {
//
//        Claim claim = new Claim();
//        claim.setStatusCode(STATUS_CODE);
//        claim.setTypeCode("TEST_TYPE");
//        claim.setRequestCode("TEST_REQUEST");
//        claim.setCauseCode("TEST_CAUSE");
//        claim.setCreator(new User());
//        claim.setCreateDt(Calendar.getInstance().getTime());
//
//        // 등록
//        claimService.addClaim(claim);
//
//        // 조회
//        ClaimDto claimDto = claimService.getClaim(claim.getClaimNo());
//
//        System.out.println(claim.hashCode());
//        System.out.println(claimDto.hashCode());
//
//        assertEquals(STATUS_CODE, claimDto.getStatusCode());
//
//        // 삭제
//        claimService.removeClaim(claimDto.getClaimNo());
//    }

    @Test
    public void 클레임_수정_이력_등록_조회() {

    }

}
