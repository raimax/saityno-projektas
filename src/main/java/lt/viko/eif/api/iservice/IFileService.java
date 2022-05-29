package lt.viko.eif.api.iservice;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService {

    String SaveFile(String uploadDir, MultipartFile multipartFile) throws IOException;
}
