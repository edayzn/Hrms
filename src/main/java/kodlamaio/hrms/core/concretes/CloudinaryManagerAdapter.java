package kodlamaio.hrms.core.concretes;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.CloudinaryManagement.CloudinaryManager;
import kodlamaio.hrms.core.abstracts.CloudinaryService;

@Service
public class CloudinaryManagerAdapter implements CloudinaryService  {

	
	private CloudinaryManager cloudinaryManager;
	
	@Autowired
	public CloudinaryManagerAdapter(CloudinaryManager cloudinaryManager) {
		super();
		this.cloudinaryManager = cloudinaryManager;
	}

	@Override
	public Map upload(MultipartFile multipartFile) throws IOException {
		return this.cloudinaryManager.upload(multipartFile);
	}

	@Override
	public Map delete(String id)throws IOException {
		return this.cloudinaryManager.delete(id);
	}

	@Override
	public File convert(MultipartFile multipartFile) throws IOException{
		return this.cloudinaryManager.convert(multipartFile);
	}

}
