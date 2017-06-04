package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @JoinColumn(name = "creator")
    private User creator;

    @Column(name = "create_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDt;

    @ManyToOne
    @JoinColumn(name = "updater")
    private User updater;

    @Column(name = "update_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDt;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_group_relation",
        joinColumns = @JoinColumn(name = "group_no"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
