package net.meshkorea.mcp.api.domain.entity.common;

import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn()
    private Codes parentCode;
}
