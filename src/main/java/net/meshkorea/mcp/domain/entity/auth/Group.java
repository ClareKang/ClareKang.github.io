package net.meshkorea.mcp.domain.entity.auth;

import lombok.Data;
import net.meshkorea.mcp.domain.entity.claim.Claim;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by reverof on 2017-06-02.
 */
@Data
@Entity
@Table(name = "group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_no")
    private Long groupNo;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "has_privacy")
    private String hasPrivacy;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @Column(name = "create_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User updater;

    @Column(name = "update_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private String updateDt;

    @Column(name = "description")
    private String description;
}
