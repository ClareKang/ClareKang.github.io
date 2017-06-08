package net.meshkorea.mcp.api.domain.repository;

import com.querydsl.jpa.JPQLQuery;
import net.meshkorea.mcp.api.domain.entity.auth.QGroup;
import net.meshkorea.mcp.api.domain.entity.auth.QUser;
import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.mcp.api.domain.model.auth.SearchUserDto;
import net.meshkorea.platform.core.web.config.data.AuthDbConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Created by reverof on 2017-06-07.
 */
@AuthDbConfig.AuthData
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public Page<User> search(SearchUserDto searchUserDto, Pageable pageable) {
        QUser user = QUser.user;
        QGroup group = QGroup.group;

        JPQLQuery<User> query = from(user);

        if (searchUserDto != null) {
            if (searchUserDto.getUserId() != null) {
                query.where(user.userId.eq(searchUserDto.getUserId()));
            }
            if (searchUserDto.getUserName() != null) {
                query.where(user.userName.eq(searchUserDto.getUserName()));
            }
            if (searchUserDto.getUserType() != null) {
                query.where(user.userType.eq(searchUserDto.getUserType()));
            }
            if (searchUserDto.getGroupId() != null || searchUserDto.getGroupName() != null) {
                query.leftJoin(user.groups, group);
                if (searchUserDto.getGroupId() != null) {
                    query.where(group.groupNo.eq(searchUserDto.getGroupId()));
                }
                if (searchUserDto.getGroupName() != null) {
                    query.where(group.groupName.eq(searchUserDto.getGroupName()));
                }
            }
        }

        List<User> users = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();

        return new PageImpl<>(users, pageable, totalCount);
    }
}
