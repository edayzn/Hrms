package kodlamaio.hrms.business.concretes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobPositions;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao advertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao advertisementDao) {
		super();
		this.advertisementDao = advertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.findAll(), "İş ilanı listelendi");

	}

	@Override
	public Result add(JobAdvertisement advertisement) {
		
		if( !advertisement.getJob_description().isEmpty() || !advertisement.getJobPosition().toString().isEmpty()|| !advertisement.getCity().isEmpty() ) {
		this.advertisementDao.save(advertisement);
		return new SuccessResuslt("Kayıt başarılı");
		}
		return new ErrorResult("Tüm alanları doldurnuz");
	

	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllActiveJob_Advertisements() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.findAllActiveJob_Advertisements(), "Aktif İş ilanı listelendi");
	}

	@Override
	public DataResult<JobAdvertisement> getByJobIdAndEmployer(int job_id, int employer_id) {
		return new SuccessDataResult<JobAdvertisement>(this.advertisementDao.getByJobIdAndEmployer(job_id, employer_id), "İş ilanı listelendi");
	}

	@Override
	public DataResult<Integer> updateJobAdvertisementSetWorkingConditionForEmployer(int jobId, int employer_id) {
		return new SuccessDataResult<Integer>(this.advertisementDao.updateJobAdvertisementSetWorkingConditionForEmployer(jobId,employer_id), "İş ilanı listelendi");
	}

}
