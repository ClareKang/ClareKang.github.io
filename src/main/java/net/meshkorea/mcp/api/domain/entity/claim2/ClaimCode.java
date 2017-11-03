package net.meshkorea.mcp.api.domain.entity.claim2;

import lombok.Data;
import net.meshkorea.mcp.api.domain.model.database.Yn;
import net.meshkorea.mcp.api.util.converter.YnToStringConverter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "claim_code")
public class ClaimCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_code_no")
    private Long claimCodeNo;

    @Column(name = "claim_code_name")
    private String claimCodeName;

    @Convert(converter = YnToStringConverter.class)
    @Column(name = "order_cancel_yn")       // 오더취소 유형 사용유무
    private Yn orderCancelYn;

    @Convert(converter = YnToStringConverter.class)
    @Column(name = "overload_yn")           // 과적 유형 사용유무
    private Yn overloadYn;

    @Convert(converter = YnToStringConverter.class)
    @Column(name = "return_yn")             // 반납 유형 사용유무
    private Yn returnYn;

    @Convert(converter = YnToStringConverter.class)
    @Column(name = "retry_yn")              // 재이동 유형 사용유무
    private Yn retryYn;

    @Convert(converter = YnToStringConverter.class)
    @Column(name = "address_change_yn")     // 주소변경 유형 사용유무
    private Yn addressChangeYn;

    @Convert(converter = YnToStringConverter.class)
    @Column(name = "phone_payment_yn")      // 전화결제 유형 사용유무
    private Yn phonePaymentYn;

    @Convert(converter = YnToStringConverter.class)
    @Column(name = "damege_yn")              // 손해배상 유형 사용유무
    private Yn damegeYn;

    @Convert(converter = YnToStringConverter.class)
    @Column(name = "use_yn")                // 클레임 코드 사용유무
    private Yn useYn;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "issue_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDt;

}
