package kodlamaio.hrms.business.abstracts;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerAndJobPositionDto;


public interface JobAdvertisementService {
	 DataResult<List<JobAdvertisement>> getAll();
	 Result add(JobAdvertisement advertisement);
	
	 
	 DataResult<List<JobAdvertisement>> findByWorkingConditionTrue();
	 
     DataResult<List<JobAdvertisement>>  findByOrderByReleaseDateDesc();
     
	 DataResult<JobAdvertisement> findByJobIdAndEmployer(int job_id, int employer_id);

		
	 Result updateJobAdvertisementSetWorkingConditionForEmployer(@Param("jobId") int jobId, @Param("employer_id") int employer_id);
	 
	 DataResult<List<JobAdvertisementWithEmployerAndJobPositionDto>> findJobAdvertisementWithEmployerAndJobPositionDetails();
}
