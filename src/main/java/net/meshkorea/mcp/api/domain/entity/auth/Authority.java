package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 2..
 */
@Data
@Entity
@Table(name = "authority")
@ToString(exclude = {"userAuthorities", "groupAuthorities", "resources"})
public class Authority implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_no")
    private Long authorityNo;

    @ManyToOne
    @JoinColumn(name = "site_code_no")
    private SiteCode siteCode;

    @Column(name = "authority_name")
    private String authorityName;

    @Column(name = "authority_code")
    private String authorityCode;

    @Column(name = "has_privacy")
    private String hasPrivacy;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "view_name")
    private String viewName;

    @Column(name = "view_uri")
    private String viewUri;

    @OneToMany(mappedBy = "authority")
    private List<UserAuthority> userAuthorities = new ArrayList<>();

    @OneToMany(mappedBy = "authority")
    private List<GroupAuthority> groupAuthorities = new ArrayList<>();

    @OneToMany(mappedBy = "authority")
    private List<Resource> resources = new ArrayList<>();

}
