package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.EducationInformationDao;
import kodlamaio.hrms.entities.concretes.EducationInformation;

@Service
public class EducationInformationManager implements EducationInformationService {

	private EducationInformationDao educationDao;
	
	@Autowired
	public EducationInformationManager(EducationInformationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<EducationInformation>> getAll() {
	
		return new SuccessDataResult<List<EducationInformation>>(this.educationDao.findAll()," Eğitim bilgileri listelendi");
	}

	@Override
	public Result add(EducationInformation educationInformation) {
		this.educationDao.save(educationInformation);
		
		return new SuccessResuslt("Eğitim bilgileri kaydedildi.");
	}

}
