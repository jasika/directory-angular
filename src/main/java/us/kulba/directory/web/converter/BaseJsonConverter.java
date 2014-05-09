package us.kulba.directory.web.converter;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseJsonConverter {

    final static Logger logger = LoggerFactory.getLogger(BaseJsonConverter.class);

    public static String convertToString(String json, String pathName) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            JsonNode rootNode = mapper.readValue(json, JsonNode.class);
            String strVal = rootNode.path(pathName).getTextValue();
            return strVal;

        } catch (Exception e) {
            logger.error("Exception ", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static Object convertNoPath(String json, Class clazz) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            return mapper.readValue(json, clazz);

        } catch (Exception e) {
            logger.error("Exception ", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static Object convert(String json, Class clazz) {
        return convert(json, clazz, new String[]{"data"});
    }

    public static Object convert(String json, Class clazz, String node[]) {
        logger.debug("Deserializing {}", json);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            JsonNode rootNode = mapper.readValue(json, JsonNode.class);
            JsonNode dataNode = rootNode.path(node[0]);

            for (int x=1; x < node.length; x++) {
                logger.debug("Search for an object using path name: " + node[x]);
                dataNode = dataNode.path(node[x]);
            }

            /** Ensure you have a dataNode. **/
            if (dataNode == null) {
                throw new RuntimeException("Unable to find an object with the path provided!");
            }

            /** Ensure the remainder is an Object. **/
            if (dataNode.isObject()) {
                return mapper.readValue(dataNode.toString(), clazz);
            } else {
                logger.error(dataNode.toString());
                throw new RuntimeException("Data found was not an object suitable for conversion!");
            }

        } catch (Exception e) {
            logger.error("Exception ", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

