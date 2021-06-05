package kodlamaio.hrms.CloudinaryManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager {
		
	   Cloudinary cloudinary;

	 	private Map<String, String> valuesMap= new HashMap<>();
	
		
		public CloudinaryManager() {
			valuesMap.put("cloud_name", "edayznayn");
			valuesMap.put("api_key", "133772244721641");
			valuesMap.put("api_secret", "hlSbiFVfuXn9Ft7sGhVBvzQ5nBM");
			cloudinary =new Cloudinary(valuesMap);
		}
		
	 	public Map upload(MultipartFile multipartFile) throws IOException {
	 		File file=convert(multipartFile);
	 		Map resMap=cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
	 		file.delete();
	 		return resMap;
	 	}
	 	
	 	public Map delete(String id) throws IOException {
	 		Map resMap=cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
	 		return resMap;
	 	}
	 	
	 	public File convert(MultipartFile multipartFile) throws IOException 
	 	{
	 		File file=new File(multipartFile.getOriginalFilename());
	 		FileOutputStream fileOutputStream= new FileOutputStream(file);
	 		fileOutputStream.write(multipartFile.getBytes());
	 		fileOutputStream.close();
	 		return file;
	 	}
	
}
