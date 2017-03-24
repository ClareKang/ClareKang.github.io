package net.meshkorea.mcp.api.entity.claim;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by reverof on 2017. 3. 17..
 */
@Data
@Entity
@Table( name = "claim_history" )
public class ClaimHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_history_no")
    private Long claimHistoryNo;

    @Column(name = "claim_no")
    private Long claimNo;

    @Column(name = "creator")
    private String creator;

    @Column(name = "create_dt")
    private Date createDt;

    @Column(name = "json_string")
    private String jsonString;
}
