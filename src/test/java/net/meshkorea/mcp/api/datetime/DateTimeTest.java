package net.meshkorea.mcp.api.datetime;

import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

/**
 * Created by reverof on 2017. 4. 28..
 */
public class DateTimeTest {

    private ZoneId zoneId = ZoneId.of("Asia/Seoul");
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS[XXX]");
    private String dateFormat1 = "2017-04-28T20:11:22.000Z";
    private String dateFormat2 = "2017-04-28T20:11:22.000+09:00";

    @Test
    public void dateFormatTest() {
        assertEquals(dateFormat1, formatter.format(getLocalDateTime(dateFormat1)));
        assertEquals(dateFormat2, formatter.format(getLocalDateTime(dateFormat2)));
    }

    private OffsetDateTime getLocalDateTime(String strDate) {
        ZonedDateTime result = ZonedDateTime.parse(strDate, formatter);
        System.out.println("ZoneId : " + zoneId);
        System.out.println("ZonedDateTime : " + result);
        System.out.println("TimeZone : " + result.getZone());
        return result.toOffsetDateTime();
    }
}
