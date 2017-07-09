package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yjhan on 2017. 7. 9..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OAuthUser {

    private String id;

    private String email;

    private String name;

    public void setEmail(String email) {
        this.email = email;
        String[] values = StringUtils.split(this.email, "@");
        if (values != null && StringUtils.isNotEmpty(values[0])) {
            this.id = values[0];
        }
    }

}
