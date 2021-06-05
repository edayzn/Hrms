package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.abstracts.CloudinaryService;
import kodlamaio.hrms.core.dataAccess.PhotoDao;
import kodlamaio.hrms.core.entities.Photo;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
@Service

public class PhotoManager implements PhotoService {

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryService) {
		super();
		this.photoDao = photoDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(Photo photo, MultipartFile multipartFile) throws IOException {
		Result result=new ErrorResult("Fotograf eklenemedi");
		Map map=cloudinaryService.upload(multipartFile);
		photo.setPhotoUrl(map.get("url").toString());
		if(!this.photoDao.getAllUserId().equals(photo.getUser().getUser_id())) {
			this.photoDao.save(photo);
			result= new SuccessResuslt("Fotograf eklendi");
		}
		return result;
	}

	@Override
	public Result update(int user_id, MultipartFile multipartFile) throws IOException {
		Map map=cloudinaryService.upload(multipartFile);
		this.photoDao.updatePhotoSetPhotoUrlForUser(map.get("url").toString(), user_id);
		return new SuccessResuslt("Fotograf güncellendi");
	}

	@Override
	public Result delete(String id) throws IOException {
		this.cloudinaryService.delete(id);
		return new SuccessResuslt("Fotograf silindi");
	}

	/*
	 * @Override public Result deletePhotoByUser(int user_id) {
	 * this.photoDao.deletePhotoByUser(user_id); return new
	 * SuccessResuslt("Veritabanında silindi"); }
	 */

}
