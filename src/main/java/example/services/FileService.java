package example.services;

import java.io.File;
import java.net.URL;

public class FileService {
    private FileService() {}

    public static File getFile(String filePath) {
        URL url = FileService.class.getClassLoader().getResource(filePath);
        if (url != null) {
            return new File(url.getFile());
        }
        return null;
    }
}
