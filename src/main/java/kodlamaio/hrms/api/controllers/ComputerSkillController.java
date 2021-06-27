package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ComputerSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ComputerSkill;
@RestController
@CrossOrigin
@RequestMapping("/api/computerSkill")
public class ComputerSkillController {
	private ComputerSkillService computerSkillService;
	@Autowired
	public ComputerSkillController(ComputerSkillService computerSkillService) {
		super();
		this.computerSkillService = computerSkillService;
	}
	@GetMapping("/getAllComputerSkill")
	public DataResult<List<ComputerSkill>> getAllComputerSkill() {
		return this.computerSkillService.getAll();
	}
	@PostMapping("/addComputerSkill")
	public Result addComputerSkill(@RequestBody ComputerSkill computerSkill) {
		return this.computerSkillService.add(computerSkill);
	}
	@PostMapping("/update")
	@Transactional
	public Result update(int id, int userId, String computerSkills) {
		return this.computerSkillService.update(id, userId, computerSkills);
	}
}
