package net.meshkorea.mcp.api.domain.model.azure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by yjhan on 2017. 6. 26..
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdUserApiResponse {

    @JsonProperty(value = "value")
    private List<AdUserSimple> adUserSimples;

}
