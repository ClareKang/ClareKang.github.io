package net.meshkorea.mcp.api.domain.repository;

import com.querydsl.jpa.JPQLQuery;
import net.meshkorea.mcp.api.domain.entity.auth.*;
import org.springframework.data.domain.PageImpl;

import java.util.List;

/**
 * Created by reverof on 2017. 6. 18..
 */
public class GroupRepositoryImpl extends AuthRepositoryQueryDslSupport implements GroupRepositoryCustom {

    public GroupRepositoryImpl() {
        super(Group.class);
    }

    public Group getGroupWithAuthorities(Long groupId) {
        QGroup group = QGroup.group;
        QAuthority authority = QAuthority.authority;
        QGroupAuthority groupAuthority = QGroupAuthority.groupAuthority;
        QResource resource = QResource.resource;

        JPQLQuery<Group> query = from(group);
        query.innerJoin(groupAuthority)
            .innerJoin(authority)
            .innerJoin(resource)
            .where(group.groupNo.eq(groupId));
        Group result = query.fetchOne();

        return result;
    }
}
