package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by reverof on 2017. 6. 16..
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthorityId implements Serializable {

    private Long user;

    private Long authority;

    @Override
    public boolean equals(Object object) {
        if (object instanceof UserAuthorityId) {
            UserAuthorityId id = (UserAuthorityId) object;
            return this.user.equals(id.getUser()) && this.authority.equals(id.getAuthority());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
