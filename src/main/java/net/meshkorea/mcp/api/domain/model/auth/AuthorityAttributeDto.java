package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by reverof on 2017. 6. 16..
 */
@Getter
@Setter
public abstract class AuthorityAttributeDto {

    private String readable;

    private String writable;

    private String editable;

    private String deletable;

    private String downloadable;
}
