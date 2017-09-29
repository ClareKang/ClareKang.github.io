package net.meshkorea.mcp.api.controller.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import net.meshkorea.mcp.api.service.business.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping(value = "/v1/intra/businessClients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * 목록 (상세정보 포함)
     *
     * @param clientType
     * @param clientName
     * @param clientAddress
     * @param enterpriseName
     * @param enterpriseNumber
     * @param enterprisePhone
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
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

    /**
     * 목록 (simple)
     *
     * @param clientType
     * @return
     * @throws Exception
     */
    @GetMapping("/list")
    public List<BusinessClientShort> getBusinessClientList(String clientType) throws Exception {
        return clientService.getBusinessClientList(clientType);
    }

    @GetMapping("/{clientId}")
    public BusinessClient getBusinessClient(@PathVariable Integer clientId) throws Exception {
        return clientService.getBusinessClient(clientId);
    }

    @PostMapping
    public BusinessClient createBusinessClient(@RequestBody BusinessClient businessClient) throws Exception {
        return clientService.createBusinessClient(businessClient);
    }

    @PutMapping("/{clientId}")
    public BusinessClient updateBusinessClient(@PathVariable Integer clientId, @RequestBody BusinessClient businessClient) throws Exception {
        return clientService.updateBusinessClient(clientId, businessClient);
    }

    @PostMapping("/{clientId}/admin_memo")
    public BusinessClient addAdminMemo(@PathVariable Integer clientId, AdminMemoRequest adminMemoRequest) throws Exception {
        return clientService.addAdminMemo(clientId, adminMemoRequest);
    }

    @GetMapping("/{clientId}/api_key")
    public ApiKey getApiKey(@PathVariable Integer clientId) throws Exception {
        return clientService.getApiKey(clientId);
    }

    @PostMapping("/{clientId}/api_key")
    public ResponseEntity createApiKey(@PathVariable Integer clientId) throws Exception {
        return clientService.createApiKey(clientId);
    }

    @GetMapping("/files/{source}/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String source, @PathVariable String fileName) throws Exception {
        return clientService.getFile(source, fileName);
    }

    @PostMapping("/{id}/files")
    public BusinessClient updateBusinessClientFiles(@PathVariable Integer id,
                                                    @RequestParam(required = false) MultipartFile enterpriseRegistrationCopy,
                                                    @RequestParam(required = false) MultipartFile bankAccountCopy,
                                                    @RequestParam(required = false) MultipartFile ceoIdCardCopy) throws Exception {
        return clientService.updateBusinessClientFiles(
                id,
                enterpriseRegistrationCopy,
                bankAccountCopy,
                ceoIdCardCopy);
    }

    // 본사(business owner)에 속한 상점 목록
    @GetMapping("/{clientId}/stores")
    public StoreListByBusinessClientId getStoreListByBusinessClientId(@PathVariable Integer clientId) throws ApiException {
        return clientService.getStoreListByBusinessClientId(clientId);
    }

    // 본사 가상계좌 조회
    @GetMapping("/{clientId}/virtual_bank_accounts")
    public BusinessClientVirtualBankAccount getBusinessClientVirtualBankAccount(@PathVariable Integer clientId) throws ApiException {
        return clientService.getBusinessClientVirtualBankAccount(clientId);
    }

}
