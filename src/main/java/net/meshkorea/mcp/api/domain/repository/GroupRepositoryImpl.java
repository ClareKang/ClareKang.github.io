package net.meshkorea.mcp.api.domain.repository;

import com.querydsl.jpa.JPQLQuery;
import net.meshkorea.mcp.api.domain.entity.auth.*;
import net.meshkorea.mcp.api.domain.model.auth.GroupListRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by reverof on 2017. 6. 18..
 */
public class GroupRepositoryImpl extends AuthRepositoryQueryDslSupport implements GroupRepositoryCustom {

    public GroupRepositoryImpl() {
        super(Group.class);
    }

    public Page<Group> getGroupWithAuthorities(GroupListRequest groupListRequest, Pageable pageable) {
        QGroup group = QGroup.group;
        QAuthority authority = QAuthority.authority;
        QGroupAuthority groupAuthority = QGroupAuthority.groupAuthority;
        QResource resource = QResource.resource;

        JPQLQuery<Group> query = from(group);

        List<Group> groups = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();

        return new PageImpl<>(groups, pageable, totalCount);
    }
}
