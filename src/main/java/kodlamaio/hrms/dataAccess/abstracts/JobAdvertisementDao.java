package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerAndJobPositionDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	@Query("SELECT job FROM JobAdvertisement job WHERE job.workingCondition =true")
	List<JobAdvertisement> findByWorkingConditionTrue();

	List<JobAdvertisement> findByOrderByReleaseDateDesc();
	
	JobAdvertisement findByJobIdAndEmployer(int job_id, int employer_id);

	@Modifying
	@Query("update JobAdvertisement set workingCondition=false where jobId=:jobId and employer.user_id= :employer_id")
	int updateJobAdvertisementSetWorkingConditionForEmployer(@Param("jobId") int jobId, @Param("employer_id") int employer_id);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerAndJobPositionDto"
			+"(j.jobId, e.company_name, ad.position_name, j.numberOfPositions, j.releaseDate, j.applicationDeadline) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join  j.jobPosition ad")
	List<JobAdvertisementWithEmployerAndJobPositionDto> findJobAdvertisementWithEmployerAndJobPositionDetails();
}
