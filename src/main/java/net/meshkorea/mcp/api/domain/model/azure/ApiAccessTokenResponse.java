package net.meshkorea.mcp.api.domain.model.azure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by yjhan on 2017. 6. 26..
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiAccessTokenResponse {

    @JsonProperty(value = "access_token")
    private String accessToken;

    @JsonProperty(value = "expires_in")
    private String expiresIn;

    @JsonProperty(value = "ext_expires_in")
    private String extExpiresIn;

    @JsonProperty(value = "token_type")
    private String tokenType;
}
