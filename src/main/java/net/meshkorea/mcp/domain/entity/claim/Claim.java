package net.meshkorea.mcp.domain.entity.claim;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by reverof on 2017. 4. 7..
 */
@Data
@Entity
@Table(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_no")
    private Long claimNo;

    @Column(name = "status_code")
    private String statusCode;

    @Column(name = "type_code")
    private String typeCode;

    @Column(name = "request_code")
    private String requestCode;

    @Column(name = "cause_code")
    private String causeCode;

    @Column(name = "customer_blame")
    private Float customerBlame;

    @Column(name = "store_blame")
    private Float storeBlame;

    @Column(name = "partner_blame")
    private Float partnerBlame;

    @Column(name = "mesh_blame")
    private Float meshBlame;

    @Column(name = "none_blame")
    private Float noneBlame;

    @Column(name = "creator")
    private String creator;

    @Column(name = "create_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDt;

    @Column(name = "updater")
    private String updater;

    @Column(name = "update_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDt;

    @OneToMany(mappedBy = "claim", cascade = CascadeType.REMOVE)
    private List<ClaimHistory> claimHistories;
}
