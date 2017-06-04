package net.meshkorea.mcp.api.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by reverof on 2017. 6. 2..
 */
@Component
public class OffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS[XXX]");

    @Override
    public OffsetDateTime deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException, NullPointerException, DateTimeParseException {
        try {
            return OffsetDateTime.parse(jsonparser.getText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            return OffsetDateTime.parse(jsonparser.getText(), DateTimeFormatter.ISO_INSTANT);
        }
    }
}
