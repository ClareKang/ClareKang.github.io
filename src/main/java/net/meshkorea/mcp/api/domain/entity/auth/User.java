package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 1..
 */
@Data
@Entity
@Table(name = "user")
public class User {

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
