package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by reverof on 2017. 6. 16..
 */
@Getter
@Setter
@MappedSuperclass
public class AuthorityAttribute implements Serializable {

    @Column(name = "readable")
    private String readable;

    @Column(name = "writable")
    private String writable;

    @Column(name = "editable")
    private String editable;

    @Column(name = "deletable")
    private String deletable;

    @Column(name = "downloadable")
    private String downloadable;
}
