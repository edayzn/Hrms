package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
//	@Modifying
//	@Query("update WorkExperience set companyName=:companyName,"
//			+ "startDate=:startDate,endDate=:endDate,workingStatus=:workingStatus"
//			+ "position_id=:positionId,sector_id=:sectorId,country_id=:countryId, city_id.cityId=:cityId "
//			+ "where jobSekeer.user_id=:user_id and  experienceId=:experienceId")
//	int update(@Param("experienceId") int experienceId, @Param("user_id") int user_id,
//			@Param("companyName") String ccompanyName, @Param("startDate") LocalDate startDate,
//			@Param("endDate") LocalDate endDate, @Param("positionId") int positionId, @Param("sectorId") int sectorId,
//			@Param("countryId") int countryId, @Param("cityId") int cityId);
//	@Modifying
//	@Query("update WorkExperience set where jobSeker.user_id=:user_id and experienceId=:experienceId")
//	int update(@Param("experienceId") int experienceId, @Param("user_id") int user_id, WorkExperience experience);
}
