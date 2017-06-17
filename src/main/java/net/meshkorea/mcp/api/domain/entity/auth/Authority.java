package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 2..
 */
@Data
@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_no")
    private Long authorityNo;

    @ManyToOne
    @JoinColumn(name = "site_code_no")
    private SiteCode siteCode;

    @Column(name = "parent_authority_no")
    private Long parentAuthorityNo;

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

    @OneToMany
    @JoinColumn(name = "parent_authority_no")
    @OrderBy("display_order ASC")
    private List<Authority> children = new ArrayList<>();

    @OneToMany(mappedBy = "authority")
    private List<UserAuthority> userAuthorities = new ArrayList<>();

    @OneToMany(mappedBy = "authority")
    private List<GroupAuthority> groupAuthorities = new ArrayList<>();

    @OneToMany(mappedBy = "authority")
    private List<Resource> resources = new ArrayList<>();

    public void setSiteCode(SiteCode siteCode) {
        if (this.siteCode != null)
            this.siteCode.getAuthorities().remove(this);

        this.siteCode = siteCode;
        this.siteCode.getAuthorities().add(this);
    }
}
