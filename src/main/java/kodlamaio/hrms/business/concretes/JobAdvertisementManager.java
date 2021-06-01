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
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerAndJobPositionDto;
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
	public DataResult<List<JobAdvertisement>> findByWorkingConditionTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.findByWorkingConditionTrue(), "Aktif iş ilanları listelendi" ) ;
	}

	@Override
	public DataResult<JobAdvertisement> findByJobIdAndEmployer(int job_id, int employer_id) {
		return new SuccessDataResult<JobAdvertisement>(this.advertisementDao.findByJobIdAndEmployer(job_id, employer_id), "İş ilanı listelendi");
	}

	@Override
	public Result updateJobAdvertisementSetWorkingConditionForEmployer(int jobId, int employer_id) {
		this.advertisementDao.updateJobAdvertisementSetWorkingConditionForEmployer(jobId,employer_id);
		return new SuccessResuslt("İş ilanı pasif");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByOrderByReleaseDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.findByOrderByReleaseDateDesc(), "İş ilanı listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerAndJobPositionDto>> findJobAdvertisementWithEmployerAndJobPositionDetails() {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerAndJobPositionDto>>(this.advertisementDao.findJobAdvertisementWithEmployerAndJobPositionDetails(), "İş ilanı listelendi");
	}

}
