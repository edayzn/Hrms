package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPositions;

@Service
public class JobPositionsManager implements JobPositionService{
	 private JobPositionDao jobPositionDao;
	 private List<String> jobPositions = new ArrayList<>();
	 
	@Autowired
	public JobPositionsManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPositions>> getAll() {
		
		return new SuccessDataResult<List<JobPositions>>(this.jobPositionDao.findAll(), " İş pozisyonları listelendi");

	}

	@Override
	public Result add(JobPositions jobPositions) {
		Result result=new ErrorResult("Girdiğiniz iş pozisyonu kayıtlı");
		
			if(positionIsItUsed(jobPositions.getPosition_name())) {
				this.jobPositionDao.save(jobPositions);
		return new SuccessResuslt("İş pozisyonu eklendi");
		}
		return result;
	}
	public boolean positionIsItUsed(String positionName) {
		boolean result = true;
		if(getPositions().contains(positionName)) {
			result = false;
		}
		return result;
	}

	@Override
	public List<String> getPositions() {
		for (JobPositions position  : getAll().getData() ) {
			jobPositions.add(position.getPosition_name());
		}
		return jobPositions;
	}
	 
	 
}
