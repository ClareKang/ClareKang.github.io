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
 * Created by reverof on 2017-06-02.
 */
@Data
@Entity
@EntityListeners(value = { AuditingEntityListener.class })
@Table(name = "auth_group")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_no")
    private Long groupNo;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_type")
    private String groupType;

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

    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "group")
    private List<GroupAuthority> groupAuthorities = new ArrayList<>();
}
