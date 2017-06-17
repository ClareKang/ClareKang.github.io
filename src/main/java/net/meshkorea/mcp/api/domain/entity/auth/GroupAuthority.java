package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by reverof on 2017. 6. 16..
 */
@Data
@Entity
@IdClass(GroupAuthorityId.class)
public class GroupAuthority extends AuthorityAttribute {

    @Id
    @ManyToOne
    @JoinColumn(name = "group_no")
    private Group group;

    @Id
    @ManyToOne
    @JoinColumn(name = "authority_no")
    private Authority authority;

}
