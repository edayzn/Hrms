package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer>{
	@Modifying
	@Query("update CoverLetter c set coverLetter=:coverLetter where c.id=:id and jobSeeker.user_id=:userId")
	int update(@Param("id") int id,@Param("userId") int userId,@Param("coverLetter") String coverLetter);
	
}
