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
@Table(name = "user_authority_relation")
public class UserAuthority {

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @ManyToOne
    @JoinColumn(name = "authority_no")
    private Authority authority;

    public void setUser(User user) {
        this.user = user;
        if (!this.user.getUserAuthorities().contains(this)) {
            this.user.getUserAuthorities().add(this);
        }
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
        if (!this.authority.getUserAuthorities().contains(this)) {
            this.authority.getUserAuthorities().add(this);
        }
    }

}
