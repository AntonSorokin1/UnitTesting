package util;

import java.io.InputStream;

public interface Converter {
    Object toObject(String string, Class<?> objectClass);

    Object toObject(InputStream inputStream, Class<?> objectClass);
}
