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
@Table(name = "user_group_relation")
public class UserGroup {

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_no")
    private Group group;

    public void setUser(User user) {
        this.user = user;
        if (!this.user.getUserGroups().contains(this)) {
            this.user.getUserGroups().add(this);
        }
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
