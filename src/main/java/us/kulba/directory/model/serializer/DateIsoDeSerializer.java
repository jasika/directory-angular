package us.kulba.directory.model.serializer;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.util.Date;

/**
 * Custom Json date serializer.
 */
public class DateIsoDeSerializer extends JsonDeserializer<Date> {

    private static final DateTimeFormatter dateFormatter = ISODateTimeFormat.dateTimeParser();

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        String dateInStr = parser.getText();
        return dateFormatter.parseDateTime(dateInStr).toDate();
    }
}