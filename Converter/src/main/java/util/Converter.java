package util;

import java.io.File;

public interface Converter {
    Object toObject(String string, Class<?> objectClass);

    Object toObject(File file, Class<?> objectClass);
}
