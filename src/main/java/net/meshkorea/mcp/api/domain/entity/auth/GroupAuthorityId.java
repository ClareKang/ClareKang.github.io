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
public class GroupAuthorityId implements Serializable {

    private Long group;

    private Long authority;

    @Override
    public boolean equals(Object object) {
        if (object instanceof GroupAuthorityId) {
            GroupAuthorityId id = (GroupAuthorityId) object;
            return this.group.equals(id.getGroup()) && this.authority.equals(id.getAuthority());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
