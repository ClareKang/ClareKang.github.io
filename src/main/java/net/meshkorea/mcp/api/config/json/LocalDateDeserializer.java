package net.meshkorea.mcp.api.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by reverof on 2017. 6. 2..
 */
@Component
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException, NullPointerException, DateTimeParseException {
        try {
            return LocalDate.parse(jsonparser.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            return LocalDate.parse(jsonparser.getText(), DateTimeFormatter.ISO_INSTANT);
        }
    }
}

