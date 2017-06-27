package net.meshkorea.mcp.api.domain.model.kmc;

import com.icert.comm.secu.IcertSecuManager;
import lombok.Getter;

@Getter
public class CertRequest {
    /**
     * 회원사 ID
     * 한국모바일인증에서 발급한 CP ID 정보
     */
    private final String cpId;

    /**
     * URL 코드
     * 서비스 호출 웹 페이지마다 등록 된 코드 정보
     */
    private final String urlCode;

    /**
     * 요청번호
     * 서비스 호출 시 Unique 한 값을 생성하여 전송
     */
    private final String certNum;

    /**
     * 요청일시
     * 요청년도월일시분초 (YYYYMMDDhhmmss)
     */
    private final String date;

    /**
     * 본인확인방법
     * M: 휴대폰 본인확인, P: 공인인증서
     */
    private final String certMethod;

    /**
     * 생년월일
     * YYMMDD
     */
    private final String birthday;

    /**
     * 성별
     * 0: 남자, 1: 여자
     */
    private final String gender;

    /**
     * 이용자 성명
     * 성명 정보
     */
    private final String name;

    /**
     * 휴대폰번호
     * 이용자의 휴대폰번호 (- 없이)
     */
    private final String phoneNo;

    /**
     * 이동통신사
     * SKT: SK 텔레콤, KTF: KT, LGT: LG U+, SKM: SKT mvno, KTM: KT mvno, LGM: LG U+ mvno
     */
    private final String phoneCorp;

    /**
     * 내외국인 정보
     * 0: 내국인, 1: 외국인
     */
    private final String nation;

    /**
     * 추가 DATA 정보
     * 최대 320Byte 까지 추가 요청정보 지원
     */
    private final String plusInfo;

    /**
     * 확장변수
     * 데이터 복호화를 위한 확장필드
     */
    private final String extendVar;

    public CertRequest(String cpId, String urlCode, String certNum, String date, String certMethod, String birthday, String gender, String name, String phoneNo, String phoneCorp, String nation, String plusInfo, String extendVar) {
        this.cpId = cpId;
        this.urlCode = urlCode;
        this.certNum = certNum;
        this.date = date;
        this.certMethod = certMethod;
        this.birthday = birthday;
        this.gender = gender;
        this.name = name;
        this.phoneNo = phoneNo;
        this.phoneCorp = phoneCorp;
        this.nation = nation;
        this.plusInfo = plusInfo;
        this.extendVar = extendVar;
    }

    public String encrypt() {
        IcertSecuManager seed = new IcertSecuManager();
        String message = cpId + "/" + urlCode + "/" + certNum + "/" + date + "/" + certMethod + "/" + birthday + "/" + gender + "/" + name + "/" + phoneNo + "/" + phoneCorp + "/" + nation + "/" + plusInfo + "/" + extendVar;
        String encryptedMessage = seed.getEnc(message, "");
        String hmacMessage = seed.getMsg(encryptedMessage);
        return seed.getEnc(encryptedMessage + "/" + hmacMessage + "/" + extendVar, "");
    }
}
