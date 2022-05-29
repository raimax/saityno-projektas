package lt.viko.eif.api.service;

import lt.viko.eif.api.iservice.IFileService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class FileService implements IFileService {

    @Override
    public String SaveFile(String uploadDir, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        String uuid = generateUUID();
        String fileExtension = getFileExtension(multipartFile.getOriginalFilename());
        String fileName = uuid + fileExtension;

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toAbsolutePath().toString();
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }

        //return fileName;
    }

    private String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.'));
    }
}
