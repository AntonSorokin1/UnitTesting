package example.services;

import java.io.*;

public class FileService {
    private FileService() {}

    public static InputStream getInputStream(String filePath) {
        return FileService.class.getClassLoader().getResourceAsStream(filePath);
    }
}
