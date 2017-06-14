package net.meshkorea.mcp.api.domain.entity.common;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 13..
 */
@Data
@Entity
@Table(name = "codes")
public class Codes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_no")
    private Long codeNo;

    @Column(name = "parent_code_no")
    private Long parent;

    @Column(name = "code")
    private String code;

    @Column(name = "code_name")
    private String codeName;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "description")
    private String description;

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

    @OneToMany
    @JoinColumn(name = "parent_code_no")
    @OrderBy("display_order ASC")
    private List<Codes> children = new ArrayList<>();
}
