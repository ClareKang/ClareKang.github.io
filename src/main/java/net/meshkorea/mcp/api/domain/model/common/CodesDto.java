package net.meshkorea.mcp.api.domain.model.common;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.common.Codes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 14..
 */
@Getter
@Setter
public class CodesDto {

    private Long codeNo;

    private Long parent;

    private String code;

    private String codeName;

    private Integer displayOrder;

    private String description;

    private String creator;

    private Date createDt;

    private String updater;

    private Date updateDt;

    private List<CodesDto> children = new ArrayList<>();

    public static CodesDto toCodesDto(Codes codes) {
        if (codes == null)
            return null;

        CodesDto codesDto = new CodesDto();
        codesDto.setCodeNo(codes.getCodeNo());
        codesDto.setParent(codes.getParent());
        codesDto.setCode(codes.getCode());
        codesDto.setCodeName(codes.getCodeName());
        codesDto.setDisplayOrder(codes.getDisplayOrder());
        codesDto.setDescription(codes.getDescription());
        codesDto.setCreator(codes.getCreator());
        codesDto.setCreateDt(codes.getCreateDt());
        codesDto.setUpdater(codes.getUpdater());
        codesDto.setUpdateDt(codes.getUpdateDt());
        codesDto.setChildren(CodesDto.toCodesDtos(codes.getChildren()));

        return codesDto;
    }

    public static List<CodesDto> toCodesDtos(List<Codes> codes) {
        if (codes == null)
            return null;

        List<CodesDto> codesDtos = new ArrayList<>();
        codes.forEach(code -> {
            codesDtos.add(CodesDto.toCodesDto(code));
        });

        return codesDtos;
    }

    public static Codes toCode(CodesDto codesDto) {
        if (codesDto == null)
            return null;

        Codes codes = new Codes();
        codes.setCodeNo(codesDto.getCodeNo());
        codes.setParent(codesDto.getParent());
        codes.setCode(codesDto.getCode());
        codes.setCodeName(codesDto.getCodeName());
        codes.setDisplayOrder(codesDto.getDisplayOrder());
        codes.setDescription(codesDto.getDescription());
        codes.setCreator(codesDto.getCreator());
        codes.setCreateDt(codesDto.getCreateDt());
        codes.setUpdater(codesDto.getUpdater());
        codes.setCreateDt(codesDto.getUpdateDt());
        codes.setChildren(CodesDto.toCodes(codesDto.getChildren()));

        return codes;
    }

    public static List<Codes> toCodes(List<CodesDto> codesDtos) {
        if (codesDtos == null)
            return null;

        List<Codes> codes = new ArrayList<>();
        codesDtos.forEach(codesDto -> {
            codes.add(CodesDto.toCode(codesDto));
        });

        return codes;
    }
}
