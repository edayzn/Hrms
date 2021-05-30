package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	@Query("SELECT job FROM JobAdvertisement job WHERE job.workingCondition = 1")
	List<JobAdvertisement> findAllActiveJob_Advertisements();

	JobAdvertisement getByJobIdAndEmployer(int job_id, int employer_id);

	@Modifying
	@Query("update JobAdvertisement set workingCondition=false where jobId=:jobId and employer.user_id= :employer_id")
	int updateJobAdvertisementSetWorkingConditionForEmployer(@Param("jobId") int jobId, @Param("employer_id") int employer_id);
}
