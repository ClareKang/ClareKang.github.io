package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.claim2.Claim2Code;
import net.meshkorea.mcp.api.domain.model.database.Yn;
import net.meshkorea.platform.core.web.config.data.MasterDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

@MasterDbConfig.MasterData
public interface Claim2CodeRepository extends JpaSpecificationRepository<Claim2Code, Long> {

    List<Claim2Code> findByOrderCancelYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<Claim2Code> findByOverloadYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<Claim2Code> findAllByReturnYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<Claim2Code> findAllByRetryYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<Claim2Code> findAllByAddressChangeYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<Claim2Code> findAllByPhonePaymentYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<Claim2Code> findAllByDamegeYnAndUseYn(Yn yn, Yn useYn, Sort sort);

    List<Claim2Code> findAllByUseYn(Yn useYn);
}
