package lt.viko.eif.api.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.util.UUID;
/**
 * This class is used for uploading images to azure storage container
 */
@Component
public class AzureStorageService {

    /**
     * This method uploads a file
     *
     * @param file Multipart file
     * @param container Storage container
     * @return file name of uploaded file
     */
    public String uploadFile(MultipartFile file, Container container) throws IOException, NotFoundException {
        String connectionString = System.getenv("AzureStorageConnectionString");

        if (connectionString == null) throw new NotFoundException("Environmental variable AzureStorageConnectionString not found");

        String fileName = generateUUID();
        String fileExtension = getFileExtension(file.getOriginalFilename());
        String fullFileName = fileName + fileExtension;

        BlobContainerClient containerClient = new BlobContainerClientBuilder()
                .connectionString(connectionString)
                .containerName(container.name())
                .buildClient();

        BlobClient blobClient = containerClient.getBlobClient(fullFileName);
        blobClient.upload(file.getInputStream(), file.getSize(), true);

        return fullFileName;
    }

    /**
     * This method is used to generate a UUID
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * This method is used to get file extension
     */
    public static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.'));
    }

    public enum Container {
        unoptimized,
        optimized
    }
}
