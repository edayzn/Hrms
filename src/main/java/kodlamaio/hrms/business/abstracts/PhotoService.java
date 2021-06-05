package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.entities.Photo;
import kodlamaio.hrms.core.utilities.results.Result;

public interface PhotoService {
	Result add(Photo photo, MultipartFile multipartFile) throws IOException;
	Result update(int user_id, MultipartFile multipartFile) throws IOException;
    Result delete(String id) throws IOException;
	//Result deletePhotoByUser(int user_id);
}
