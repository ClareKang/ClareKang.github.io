package net.meshkorea.mcp.api.controller.business;

import com.meshprime.api.client.model.*;
import net.meshkorea.mcp.api.service.business.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping(value = "/intra/v1/businessClients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ListBusinessClientResponse listBusinessClients(String clientType,
                                                          String clientName,
                                                          String clientAddress,
                                                          String enterpriseName,
                                                          String enterpriseNumber,
                                                          String enterprisePhone,
                                                          Integer page,
                                                          Integer size) throws Exception {
        return clientService.listBusinessClients(
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

    @GetMapping(value = "/list")
    public List<BusinessClientShort> getBusinessClientList(String clientType) throws Exception {
        return clientService.getBusinessClientList(clientType);
    }

    @GetMapping(value = "/{clientId}")
    public BusinessClient getBusinessClient(@PathVariable Integer clientId) throws Exception {
        return clientService.getBusinessClient(clientId);
    }

    @PostMapping
    public BusinessClient createBusinessClient(@RequestBody BusinessClient businessClient) throws Exception {
        return clientService.createBusinessClient(businessClient);
    }

    @PutMapping(value = "/{clientId}")
    public BusinessClient updateBusinessClient(@PathVariable Integer clientId, @RequestBody BusinessClientRequest businessClient) throws Exception {
        return clientService.updateBusinessClient(clientId, businessClient);
    }

    @PostMapping(value = "/{clientId}/admin_memo")
    public BusinessClient addAdminMemo(@PathVariable Integer clientId, AdminMemoRequest adminMemoRequest) throws Exception {
        return clientService.addAdminMemo(clientId, adminMemoRequest);
    }

    @GetMapping(value = "/{clientId}/api_key")
    public ApiKey getApiKey(@PathVariable Integer clientId) throws Exception {
        return clientService.getApiKey(clientId);
    }

    @PostMapping(value = "/{clientId}/api_key")
    public ApiKey createApiKey(@PathVariable Integer clientId) throws Exception {
        return clientService.createApiKey(clientId);
    }

    @GetMapping("/files/{source}/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String source, @PathVariable String fileName) throws Exception {
        return clientService.getFile(source, fileName);
    }

}
