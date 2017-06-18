package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by reverof on 2017. 6. 16..
 */
@Data
@EqualsAndHashCode(callSuper = false)
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

    public void setGroup(Group group) {
        if (this.group.getGroupAuthorities() != null)
            this.group.getGroupAuthorities().remove(this);

        this.group = group;
        this.group.getGroupAuthorities().add(this);
    }

    public void setAuthority(Authority authority) {
        if (this.authority.getGroupAuthorities() != null)
            this.authority.getGroupAuthorities().remove(this);

        this.authority = authority;
        this.authority.getGroupAuthorities().add(this);
    }

}
