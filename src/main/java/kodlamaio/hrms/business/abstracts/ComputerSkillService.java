package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ComputerSkill;

public interface ComputerSkillService {
	DataResult<List<ComputerSkill>> getAll();
	Result add(ComputerSkill computerSkill);
	Result update(@Param("id") int id,@Param("userId") int userId, @Param("computerSkills") String computerSkills );
	
}
