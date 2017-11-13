package net.meshkorea.mcp.api.util.converter;

import net.meshkorea.mcp.api.domain.model.database.Yn;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class YnToStringConverter implements AttributeConverter<Yn, String> {

    @Override
    public String convertToDatabaseColumn(Yn value) {
        return (value != null && value == Yn.Y) ? "Y" : "N";
    }

    @Override
    public Yn convertToEntityAttribute(String value) {
        return "Y".equals(value) ? Yn.Y : Yn.N;
    }
}
