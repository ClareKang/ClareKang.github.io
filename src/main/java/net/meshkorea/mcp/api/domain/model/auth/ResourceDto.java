package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by reverof on 2017. 6. 16..
 */
@Getter
@Setter
public class ResourceDto {

    private Long resourceNo;

    private AuthorityDto authorityDto;

    private String resourceName;

    private String resourceUri;

    public void setAutorityDto(AuthorityDto autorityDto) {
        if (this.authorityDto != null)
            this.authorityDto.getResourceDtos().remove(this);

        this.authorityDto = autorityDto;
        this.authorityDto.getResourceDtos().add(this);
    }
}
