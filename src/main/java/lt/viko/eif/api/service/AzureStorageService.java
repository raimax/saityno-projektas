package lt.viko.eif.api.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
public class AzureStorageService {
    public String uploadFile(MultipartFile file) throws IOException {
        String connectionString = "DefaultEndpointsProtocol=https;AccountName=saitynasimages;AccountKey=CjXeH6x3uwmZUV0IUafdsQdgpOrFgzEQNoPJ1ddxd3D/azqFWFGv2nJz3ZOyAM9gJ85p1N7tB3PO+ASt45PxdQ==;EndpointSuffix=core.windows.net";
        String fileName = generateUUID();
        String fileExtension = getFileExtension(file.getOriginalFilename());
        String fullFileName = fileName + fileExtension;

        BlobContainerClient containerClient = new BlobContainerClientBuilder()
                .connectionString(connectionString)
                .containerName("unoptimized")
                .buildClient();

        BlobClient blobClient = containerClient.getBlobClient(fullFileName);
        blobClient.upload(file.getInputStream(), file.getSize(), true);

        return fullFileName;
    }

    private String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.'));
    }
}
