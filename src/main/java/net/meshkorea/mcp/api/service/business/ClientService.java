package net.meshkorea.mcp.api.service.business;

import com.meshprime.api.client.model.*;
import com.meshprime.intra.api.IntraBusinessClientsApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import net.meshkorea.mcp.api.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by reverof on 2017. 4. 17..
 */
@Service
@DependsOn({
        "fileSystemStorageService"
})
public class ClientService {

    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraBusinessClientsApi intraBusinessClientsApi;

    @Autowired
    private StorageService storageService;

    public ListBusinessClientResponse listBusinessClients(String clientType,
                                                          String clientName,
                                                          String clientAddress,
                                                          String enterpriseName,
                                                          String enterpriseNumber,
                                                          String enterprisePhone,
                                                          Integer page,
                                                          Integer size) throws Exception {
        return intraBusinessClientsApi.listBusinessClients(
                intraTokenService.getAuthToken(),
                clientType,
                clientName,
                clientAddress,
                enterpriseName,
                enterpriseNumber,
                enterprisePhone,
                page,
                size
        );
    }

    public List<BusinessClientShort> getBusinessClientList(String clientType) throws Exception {
        return intraBusinessClientsApi.getBusinessClientList(intraTokenService.getAuthToken(), clientType);
    }

    public BusinessClient getBusinessClient(Integer clientId) throws Exception {
        return intraBusinessClientsApi.getBusinessClient(intraTokenService.getAuthToken(), clientId);
    }

    public BusinessClient createBusinessClient(BusinessClient businessClient) throws Exception {
        return intraBusinessClientsApi.createBusinessClient(intraTokenService.getAuthToken(), businessClient);
    }

    public BusinessClient updateBusinessClient(Integer clientId, BusinessClientRequest businessClientRequest) throws Exception {
        return intraBusinessClientsApi.updateBusinessClient(intraTokenService.getAuthToken(), clientId, businessClientRequest);
    }

    public BusinessClient addAdminMemo(Integer clientId, AdminMemoRequest adminMemoRequest) throws Exception {
        return intraBusinessClientsApi.addBusinessClientAdminMemo(intraTokenService.getAuthToken(), clientId, adminMemoRequest);
    }

    public ApiKey getApiKey(Integer clientId) throws Exception {
        return intraBusinessClientsApi.getBusinessClientApiKey(intraTokenService.getAuthToken(), clientId);
    }

    public ApiKey createApiKey(Integer clientId) throws Exception {
        return intraBusinessClientsApi.createBusinessClientApiKey(intraTokenService.getAuthToken(), clientId);
    }

    public ResponseEntity<Resource> getFile(String source, String fileName) throws Exception {

        File file = intraBusinessClientsApi.getFile(intraTokenService.getAuthToken(), source, fileName);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Description", "File Transfer");
        httpHeaders.add("Content-Description", "attachment; filename=" + fileName);

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }

}
