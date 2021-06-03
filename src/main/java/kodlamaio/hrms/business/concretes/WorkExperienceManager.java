package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;
@Service
public class WorkExperienceManager implements WorkExperienceService{

	private WorkExperienceDao  experienceDao;
	
	@Autowired
	public WorkExperienceManager(WorkExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		
		return new SuccessDataResult<List<WorkExperience>>(this.experienceDao.findAll()," İş deneyimi listelendi.");
	}

	@Override
	public Result add(WorkExperience workExperience) {
		this.experienceDao.save(workExperience);
		return new SuccessResuslt("İş deneyimi eklendi.");
	}

}
