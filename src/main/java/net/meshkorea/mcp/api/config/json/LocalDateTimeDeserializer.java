package net.meshkorea.mcp.api.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by reverof on 2017. 6. 2..
 */
@Component
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException, NullPointerException, DateTimeParseException {
        try {
            return LocalDateTime.parse(jsonparser.getText(), DateTimeFormatter.ISO_INSTANT);
        } catch (DateTimeParseException e) {
            try {
                return LocalDateTime.parse(jsonparser.getText(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            } catch (DateTimeParseException ee) {
                return LocalDateTime.parse(jsonparser.getText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            }
        }
    }
}

