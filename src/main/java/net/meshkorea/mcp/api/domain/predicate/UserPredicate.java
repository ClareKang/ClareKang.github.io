package net.meshkorea.mcp.api.domain.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import net.meshkorea.mcp.api.domain.entity.auth.QUser;

/**
 * Created by reverof on 2017-06-06.
 */
public class UserPredicate {
    public static Predicate search(String userId, String userName) {
        QUser user = QUser.user;

        BooleanBuilder builder = new BooleanBuilder();
        if (userId != null) {
            // user.userId
            //builder.and(user.userId.);
        }
        if (userName != null) {
            //builder.and(userGrop.users.any().name.like("%" + userName + "%"));
        }

        return builder;
    }
}
