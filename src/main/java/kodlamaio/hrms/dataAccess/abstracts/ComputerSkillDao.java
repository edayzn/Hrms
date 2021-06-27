package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.ComputerSkill;

public interface ComputerSkillDao extends JpaRepository<ComputerSkill, Integer> {
	@Modifying
	@Query("update ComputerSkill c set computerSkills=:computerSkills where c.id=:id and jobSeeker.user_id=:userId")
	int update(@Param("id") int id,@Param("userId") int userId, @Param("computerSkills") String computerSkills);
	
}