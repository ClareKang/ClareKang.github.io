package net.meshkorea.mcp.api.domain.repository;

import com.querydsl.jpa.JPQLQuery;
import net.meshkorea.mcp.api.domain.entity.auth.QGroup;
import net.meshkorea.mcp.api.domain.entity.auth.QUser;
import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.mcp.api.domain.model.auth.UserListRequest;
import net.meshkorea.platform.core.web.config.data.AuthDbConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by reverof on 2017-06-07.
 */
@AuthDbConfig.AuthData
public class UserRepositoryImpl extends AuthRepositoryQueryDslSupport implements UserRepositoryCustom {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public Page<User> search(UserListRequest userListRequest, Pageable pageable) {
        QUser user = QUser.user;
        QGroup group = QGroup.group;

        JPQLQuery<User> query = from(user);

        if (userListRequest != null) {
            if (userListRequest.getUserId() != null) {
                query.where(user.userId.eq(userListRequest.getUserId()));
            }
            if (userListRequest.getUserName() != null) {
                query.where(user.userName.eq(userListRequest.getUserName()));
            }
            if (userListRequest.getUserType() != null) {
                query.where(user.userType.eq(userListRequest.getUserType()));
            }
            if (userListRequest.getGroupId() != null || userListRequest.getGroupName() != null) {
                query.leftJoin(user.groups, group);
                if (userListRequest.getGroupId() != null) {
                    query.where(group.groupNo.eq(userListRequest.getGroupId()));
                }
                if (userListRequest.getGroupName() != null) {
                    query.where(group.groupName.eq(userListRequest.getGroupName()));
                }
            }
        }

        List<User> users = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();

        return new PageImpl<>(users, pageable, totalCount);
    }
}
