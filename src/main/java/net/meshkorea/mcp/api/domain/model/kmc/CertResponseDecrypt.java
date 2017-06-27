package net.meshkorea.mcp.api.domain.model.kmc;

import com.icert.comm.secu.IcertSecuManager;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public class CertResponseDecrypt {
    /**
     * 요청번호
     * 서비스 인증번호 (복호화 Key)
     */
    private final String certNum;

    /**
     * 요청일시
     * 서비스 요청일시
     */
    private final String date;

    /**
     * Unique 한 식별정보
     */
    private final String ci;

    /**
     * 휴대폰번호
     * 이용자의 휴대폰번호 (- 없이)
     */
    private final String phoneNo;

    /**
     * 이동통신사
     * SKT: SK텔레콤, KTF: KT, LGT: LG U+, SKM: SKT mvno, KTM: KT mvno, LGM: LG U+ mvno
     */
    private final String phoneCorp;

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
     * 내외국인 정보
     * 0: 내국인, 1: 외국인
     */
    private final String nation;

    /**
     * 이용자 성명
     * 성명 정보
     */
    private final String name;

    /**
     * 결과값
     * 본인인증 결과 값
     */
    private final String result;

    /**
     * 본인확인방법
     * M: 휴대폰 본인확인, P: 공인인증서
     */
    private final String certMethod;

    /**
     * IP 주소
     * 이용자 IP 주소 정보
     */
    private final String ip;

    /**
     * 성명 (14세 미만)
     * 14세 미만 성명 정보
     */
    private final String underAgeName;

    /**
     * 생년월일 (14세 미만)
     * 14세 미만 생년월일 정보
     */
    private final String underAgeBirthday;

    /**
     * 성별 (14세 미만)
     * 14세 미만 성별 정보
     */
    private final String underAgeGender;

    /**
     * 내외국인정보 (14세 미만)
     * 14세 미만 내외국인 정보
     */
    private final String underAgeNation;

    /**
     * 추가 DATA 정보
     * 최대 320Byte 까지 추가 요청정보 지원
     */
    private final String plusInfo;

    /**
     * 중복가입확인정보
     * Unique 한 식별정보 (웹사이트 기준)
     */
    private final String di;

    /**
     * 확장변수
     * 데이터 복호화를 위한 확장필드
     */
    private final String extendVar;

    public CertResponseDecrypt(String recCert, String certNum) throws Exception {
        IcertSecuManager seed = new IcertSecuManager();

        String decryptedMessage1 = seed.getDec(recCert, certNum);
        String[] splitMessage1 = StringUtils.delimitedListToStringArray(decryptedMessage1, "/");

        String encryptParameter = splitMessage1[0];
        String encryptMessage1 = splitMessage1[1];
        String encryptMessage2 = seed.getMsg(encryptParameter);
        if (!encryptMessage2.equals(encryptMessage1)) {
            throw new Exception();
        }

        String decryptedMessage2 = seed.getDec(encryptParameter, certNum);
        String[] parse = StringUtils.delimitedListToStringArray(decryptedMessage2, "/");

        this.certNum = parse[0];
        this.date = parse[1];
        this.ci = parse[2];
        this.phoneNo = parse[3];
        this.phoneCorp = parse[4];
        this.birthday = parse[5];
        this.gender = parse[6];
        this.nation = parse[7];
        this.name = parse[8];
        this.result = parse[9];
        this.certMethod = parse[10];
        this.ip = parse[11];
        this.underAgeName = parse[12];
        this.underAgeBirthday = parse[13];
        this.underAgeGender = parse[14];
        this.underAgeNation = parse[15];
        this.plusInfo = parse[16];
        this.di = parse[17];
        this.extendVar = parse[18];
    }

}
