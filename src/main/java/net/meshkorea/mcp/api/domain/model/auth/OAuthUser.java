package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

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
        if (StringUtils.contains(email, "@")) {
            String[] values = StringUtils.split(email, "@");
            setId(values[0]);
        } else {
            setId(email);
        }
    }

}
