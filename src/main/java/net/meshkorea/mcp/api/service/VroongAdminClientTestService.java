package net.meshkorea.mcp.api.service;

import com.vroong.admin.api.AdminAdminApi;
import com.vroong.admin.api.client.model.PagedResourcesOfResourceOfAdminDto;
import com.vroong.admin.service.auth.AdminTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by reverof on 2017. 2. 28..
 */
@Service
public class VroongAdminClientTestService {

    @Autowired
    AdminTokenService adminTokenService;

    @Autowired
    AdminAdminApi adminAdminApi;

    public PagedResourcesOfResourceOfAdminDto getAdmins() throws Exception {
        return adminAdminApi.getAdminsUsingGET(adminTokenService.getAuthToken(), "", "", "");
    }
}
