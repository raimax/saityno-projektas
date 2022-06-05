package lt.viko.eif.api.service;

import lt.viko.eif.api.models.ReshmushResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URL;

/**
 * This class implements ImageOptimizationService
 */
@Service
public class ImageOptimizationServiceImpl implements ImageOptimizationService{
    private final String reshmushUrl = "http://api.resmush.it/ws.php?img=";
    private final String storageUrl = "https://saitynasimages.blob.core.windows.net/unoptimized/";
    private final String imageQuality = "&qlty=80";
    private final HttpService<ReshmushResponse> httpService;
    private final AzureStorageService storageService;

    /**
     * Injects an instance of AzureStorageService and HttpService
     */
    @Autowired
    public ImageOptimizationServiceImpl(HttpService<ReshmushResponse> httpService, AzureStorageService storageService) {
        this.httpService = httpService;
        this.storageService = storageService;
    }

    /**
     * This method optimizes image
     *
     * @param imageName name of the image
     * @return status string
     */
    @Override
    public String optimizeImage(String imageName) {
        ReshmushResponse response = httpService.get(reshmushUrl + storageUrl + imageName + imageQuality);

        try {
            URL url = new URL(response.getDest());
            InputStream in = url.openStream();

            String imageType = AzureStorageService.getFileExtension(imageName).replace(".", "");
            String fileName = imageName;

            MultipartFile multipartFile = new MockMultipartFile(fileName, fileName, "image/" + imageType, in.readAllBytes());
            in.close();

            return storageService.uploadFile(multipartFile, AzureStorageService.Container.optimized);
        } catch (Exception e) {
            System.out.println("Failed to get image from url");
            return null;
        }

    }
}
