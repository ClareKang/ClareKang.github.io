package net.meshkorea.mcp.api.domain.entity.claim;

import lombok.Data;
import net.meshkorea.mcp.api.domain.entity.auth.User;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
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

    @ManyToOne
    @JoinColumn(name = "creator", referencedColumnName = "user_id")
    private User creator;

    @Column(name = "create_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDt;

    @ManyToOne
    @JoinColumn(name = "updater", referencedColumnName = "user_id")
    private User updater;

    @Column(name = "update_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDt;

    @OneToMany(mappedBy = "claim", fetch = FetchType.EAGER)
    private List<ClaimHistory> claimHistories = new ArrayList<>();
}
