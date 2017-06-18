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
@IdClass(UserAuthorityId.class)
public class UserAuthority extends AuthorityAttribute {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "authority_no")
    private Authority authority;

    public void setUser(User user) {
        if (this.user.getUserAuthorities() != null)
            this.user.getUserAuthorities().remove(this);

        this.user = user;
        this.user.getUserAuthorities().add(this);
    }

    public void setAuthority(Authority authority) {
        if (this.authority.getUserAuthorities() != null)
            this.authority.getUserAuthorities().remove(this);

        this.authority = authority;
        this.authority.getUserAuthorities().add(this);
    }
}
