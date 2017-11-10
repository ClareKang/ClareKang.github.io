package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.claim2.ClaimCode;
import net.meshkorea.mcp.api.domain.model.database.Yn;
import net.meshkorea.platform.core.web.config.data.MasterDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

@MasterDbConfig.MasterData
public interface ClaimCodeRepository extends JpaSpecificationRepository<ClaimCode, Long> {

    List<ClaimCode> findByOrderCancelYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<ClaimCode> findByOverloadYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<ClaimCode> findAllByReturnYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<ClaimCode> findAllByRetryYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<ClaimCode> findAllByAddressChangeYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<ClaimCode> findAllByPhonePaymentYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<ClaimCode> findAllByDamegeYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<ClaimCode> findAllByUseYn(Yn useYn);
}
