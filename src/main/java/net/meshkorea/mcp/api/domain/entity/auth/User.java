package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;

import javax.persistence.*;
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

    @Column(name = "creator")
    private String creator;

    @Column(name = "create_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDt;

    @Column(name = "updater")
    private String updater;

    @Column(name = "update_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDt;

    @Column(name = "description")
    private String description;

    @Column(name = "memo")
    private String memo;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<UserGroup> userGroups;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "user_group_relation",
        joinColumns = @JoinColumn(name = "user_no"),
        inverseJoinColumns = @JoinColumn(name = "group_no"))
    private List<Group> groups;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<UserAuthority> userAuthorities;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "user_authority_relation",
        joinColumns = @JoinColumn(name = "user_no"),
        inverseJoinColumns = @JoinColumn(name = "authority_no"))
    private List<Authority> authorities;
}
