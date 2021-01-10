package util.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import util.JSONConverter;

import java.io.*;
import java.util.logging.Logger;

public class JSONConverterImpl implements JSONConverter {
    private static final Logger LOGGER = Logger.getLogger(JSONConverterImpl.class.getName());

    @Override
    public String toJSON(Object object) {
        try {
            StringWriter writer = new StringWriter();
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(writer, object);
            return writer.toString();
        }
        catch (IOException exception) {
            LOGGER.warning("Cannot write value! " + exception.toString());
        }
        return null;
    }

    @Override
    public Object toObject(String string, Class<?> objectClass) {
        try {
            StringReader reader = new StringReader(string);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(reader, objectClass);
        }
        catch (IOException exception) {
            LOGGER.warning("Cannot read value! " + exception.toString());
        }
        return null;
    }

    @Override
    public Object toObject(File file, Class<?> objectClass) {
        try {
            FileReader reader = new FileReader(file);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(reader, objectClass);
        }
        catch (IOException exception) {
            LOGGER.warning("Cannot read value! " + exception.toString());
        }
        return null;
    }
}
