package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by reverof on 2017. 6. 10..
 */
@Getter
@Setter
public class UserDto {

    private Long userNo;

    private String userId;

    private String userName;

    private String userType;

    private String phone;

    private String email;

    private String isActive;

    private String hasPrivacy;

    private String creator;

    private Date createDt;

    private String updater;

    private Date updateDt;

    private String description;

    private String memo;

}
