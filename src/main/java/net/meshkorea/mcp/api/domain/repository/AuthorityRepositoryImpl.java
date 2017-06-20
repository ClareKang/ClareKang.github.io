package net.meshkorea.mcp.api.domain.repository;

import com.querydsl.jpa.JPQLQuery;
import net.meshkorea.mcp.api.domain.entity.auth.*;

import java.util.List;

/**
 * Created by reverof on 2017-06-19.
 */
public class AuthorityRepositoryImpl extends AuthRepositoryQueryDslSupport implements AuthorityRepositoryCustom {

    public AuthorityRepositoryImpl() {
        super(Authority.class);
    }

    public List<Authority> getAllAuthoritiesWithGrantedGroups(Long groupId) {
        QGroup group = QGroup.group;
        QAuthority authority = QAuthority.authority;
        QGroupAuthority groupAuthority = QGroupAuthority.groupAuthority;
        QResource resource = QResource.resource;

        JPQLQuery<Authority> query = from(authority);
        query.innerJoin(authority.resources, resource)
            .fetchJoin();
        if (groupId != null && groupId != 0) {
            query.leftJoin(authority.groupAuthorities, groupAuthority)
                .fetchJoin()
                .leftJoin(groupAuthority.group, group)
                .on(group.groupNo.eq(groupId));
        }

        query.orderBy(authority.displayOrder.asc());

        return query.fetch();
    }
}
