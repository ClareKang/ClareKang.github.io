package net.meshkorea.mcp.api.service.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import com.meshprime.intra.api.IntraBusinessClientsApi;
import com.meshprime.intra.api.IntraVirtualBankAccount;
import com.meshprime.intra.service.auth.IntraTokenService;
import net.meshkorea.mcp.api.util.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    private IntraTokenService intraTokenService;

    @Autowired
    private IntraBusinessClientsApi intraBusinessClientsApi;

    @Autowired
    private StorageService storageService;

    @Autowired
    IntraVirtualBankAccount intraVirtualBankAccount;

    public ListBusinessClientResponse listBusinessClients(
            String clientType,
            String clientName,
            String clientAddress,
            String enterpriseName,
            String enterpriseNumber,
            String enterprisePhone,
            Integer page,
            Integer size
    ) throws Exception {
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

    public BusinessClient updateBusinessClient(Integer clientId, BusinessClient businessClientRequest) throws Exception {
        return intraBusinessClientsApi.updateBusinessClient(intraTokenService.getAuthToken(), clientId, businessClientRequest);
    }

    public BusinessClient addAdminMemo(Integer clientId, AdminMemoRequest adminMemoRequest) throws Exception {
        return intraBusinessClientsApi.addBusinessClientAdminMemo(intraTokenService.getAuthToken(), clientId, adminMemoRequest);
    }

    public ApiKey getApiKey(Integer clientId) throws Exception {
        try {
            return intraBusinessClientsApi.getBusinessClientApiKey(intraTokenService.getAuthToken(), clientId);
        } catch (ApiException e) {
            if (e.getCode() == HttpStatus.NOT_FOUND.value()) {
                return new ApiKey();
            } else {
                throw e;
            }
        }
    }

    public ResponseEntity createApiKey(Integer clientId) throws Exception {
        try {
            return ResponseEntity.ok(intraBusinessClientsApi.createBusinessClientApiKey(intraTokenService.getAuthToken(), clientId));
        } catch (ApiException e) {
            return ResponseEntity.badRequest().body(e.getResponseBody());
        }

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

    public BusinessClient updateBusinessClientFiles(
            Integer clientId,
            MultipartFile enterpriseRegistrationCopy,
            MultipartFile bankAccountCopy,
            MultipartFile ceoIdCardCopy
    ) throws Exception {

        File enterpriseRegistrationCopyFile = null;
        File bankAccountCopyFile = null;
        File ceoIdCardCopyFile = null;

        BusinessClient result = null;

        try {
            if (enterpriseRegistrationCopy != null) {
                enterpriseRegistrationCopyFile = storageService.store(enterpriseRegistrationCopy).toFile();
            }
            if (bankAccountCopy != null) {
                bankAccountCopyFile = storageService.store(bankAccountCopy).toFile();
            }
            if (ceoIdCardCopy != null) {
                ceoIdCardCopyFile = storageService.store(ceoIdCardCopy).toFile();
            }

            result = intraBusinessClientsApi.updateBusinessClientFiles(intraTokenService.getAuthToken(),
                    clientId, enterpriseRegistrationCopyFile, bankAccountCopyFile, ceoIdCardCopyFile);
        } catch (Exception e) {

        } finally {
            if (enterpriseRegistrationCopyFile != null && enterpriseRegistrationCopyFile.exists()) {
                enterpriseRegistrationCopyFile.delete();
            }
            if (bankAccountCopyFile != null && bankAccountCopyFile.exists()) {
                bankAccountCopyFile.delete();
            }
            if (ceoIdCardCopyFile != null && ceoIdCardCopyFile.exists()) {
                ceoIdCardCopyFile.delete();
            }
        }

        return result;
    }

    // 본사(business owner)에 속한 상점 목록
    public StoreListByBusinessClientId getStoreListByBusinessClientId(Integer clientId) throws ApiException {
        return intraBusinessClientsApi.getStoreListByBusinessClientId(intraTokenService.getAuthToken(), clientId);
    }

    // 본사 가상계좌 조회
    public BusinessClientVirtualBankAccount getBusinessClientVirtualBankAccount(Integer clientId) throws ApiException {
        return intraBusinessClientsApi.getBusinessClientVirtualBankAccount(intraTokenService.getAuthToken(), clientId.toString());
    }
}
