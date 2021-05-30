package kodlamaio.hrms.business.abstracts;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService {
	 DataResult<List<JobAdvertisement>> getAll();
	 Result add(JobAdvertisement advertisement);
	 
	 @Query("SELECT job FROM JobAdvertisement job WHERE job.workingCondition = 1")
	 DataResult<List<JobAdvertisement>> findAllActiveJob_Advertisements();

	 DataResult<JobAdvertisement> getByJobIdAndEmployer(int job_id, int employer_id);

		
	 DataResult<Integer> updateJobAdvertisementSetWorkingConditionForEmployer(@Param("jobId") int jobId, @Param("employer_id") int employer_id);
}
