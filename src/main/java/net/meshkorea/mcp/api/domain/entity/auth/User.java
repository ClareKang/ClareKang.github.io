package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 1..
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

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

    @ManyToOne
    @JoinColumn(name = "creator", referencedColumnName = "user_id", updatable = false)
    private User creator;

    @CreatedDate
    @Column(name = "create_dt", updatable = false)
    private LocalDateTime createDt;

    @ManyToOne
    @JoinColumn(name = "updater", referencedColumnName = "user_id")
    private User updater;

    @LastModifiedDate
    @Column(name = "update_dt")
    private LocalDateTime updateDt;

    @Column(name = "description")
    private String description;

    @Column(name = "memo")
    private String memo;

    @OneToMany(mappedBy = "user")
    private List<UserAuthority> userAuthorities = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_group_relation",
        joinColumns = @JoinColumn(name = "user_no"),
        inverseJoinColumns = @JoinColumn(name = "group_no"))
    private List<Group> groups = new ArrayList<>();
}
