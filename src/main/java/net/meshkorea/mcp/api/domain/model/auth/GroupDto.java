package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 10..
 */
@Getter
@Setter
public class GroupDto {

    private Long groupNo;

    private String groupName;

    private String isActive;

    private String hasPrivacy;

    private UserDto creator;

    private Date createDt;

    private UserDto updater;

    private Date updateDt;

    private String description;

    private List<UserDto> users;
}
