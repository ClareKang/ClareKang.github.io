package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by reverof on 2017. 6. 2..
 */
@Data
@Entity
@Table(name = "site_code")
public class SiteCode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_code_no")
    private Long siteCodeNo;

    @Column(name = "site_code")
    private String siteCode;

    @Column(name = "site_name")
    private String siteName;

}
