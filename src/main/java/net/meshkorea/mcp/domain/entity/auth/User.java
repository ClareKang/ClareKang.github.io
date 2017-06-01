package net.meshkorea.mcp.domain.entity.auth;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by reverof on 2017. 6. 1..
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "has_privacy")
    private String hasPrivacy;

    @Column(name = "creator")
    private String creator;

    @Column(name = "create_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDt;

    @Column(name = "updater")
    private String updater;

    @Column(name = "update_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private String updateDt;

    @Column(name = "description")
    private String description;

    @Column(name = "memo")
    private String memo;
}
