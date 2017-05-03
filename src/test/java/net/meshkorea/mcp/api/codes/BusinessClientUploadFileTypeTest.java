package net.meshkorea.mcp.api.codes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by reverof on 2017. 4. 25..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessClientUploadFileTypeTest {

    @Test
    public void 포함_여부_확인() {
        BusinessClientUploadFileType.ENTERPRISE_REGISTRATION_COPY.isEquals("enterprise_registration_copy");
        BusinessClientUploadFileType.BANK_ACCOUNT_COPY.isEquals("bank_account_copy");
        BusinessClientUploadFileType.CEO_ID_CARD_COPY.isEquals("ceo_id_card_copy");
    }
}
