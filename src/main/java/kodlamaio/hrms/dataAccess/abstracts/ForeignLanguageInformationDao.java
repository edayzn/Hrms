package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.ForeignLanguageInformation;

public interface ForeignLanguageInformationDao extends JpaRepository<ForeignLanguageInformation, Integer> {
	@Modifying
	@Query("update ForeignLanguageInformation set language_id=:languageId , level_id=:levelId where id=:id and jobSeeker.user_id=:userId")
	int update(@Param("id") int id, @Param("userId") int userId,@Param("levelId") int levelId, @Param("languageId") int languageId);
}
