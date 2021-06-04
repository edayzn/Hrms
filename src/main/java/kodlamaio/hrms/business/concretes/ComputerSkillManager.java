package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ComputerSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.ComputerSkillDao;
import kodlamaio.hrms.entities.concretes.ComputerSkill;
@Service
public class ComputerSkillManager implements ComputerSkillService {

	private ComputerSkillDao computerSkillDao;
	
	@Autowired
	public ComputerSkillManager(ComputerSkillDao computerSkillDao) {
		super();
		this.computerSkillDao = computerSkillDao;
	}

	@Override
	public DataResult<List<ComputerSkill>> getAll() {
		return new SuccessDataResult<List<ComputerSkill>>(this.computerSkillDao.findAll(),"Bilgisayar yetenekleri listelendi.");
	}

	@Override
	public Result add(ComputerSkill computerSkill) {
		this.computerSkillDao.save(computerSkill);
		return new SuccessResuslt("Bilgisayar yetenekleri eklendi");
	}

}
