package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by reverof on 2017. 6. 11..
 */
@Data
@Entity
@Table(name = "group_authority_relation")
public class GroupAuthority {

    @ManyToOne
    @JoinColumn(name = "group_no")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "authority_no")
    private Authority authority;

    public void setGroup(Group group) {
        this.group = group;
        if (!this.group.getGroupAuthorities().contains(this)) {
            this.group.getGroupAuthorities().add(this);
        }
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
        if (!this.authority.getGroupAuthorities().contains(this)) {
            this.authority.getGroupAuthorities().add(this);
        }
    }
}
