package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;
@RestController
@CrossOrigin
@RequestMapping("/api/workExperiences")
public class WorkExperienceController {

	private WorkExperienceService experienceService;
	
	@Autowired
	public WorkExperienceController(WorkExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	@GetMapping("/getAllWorkExperience")
	public DataResult<List<WorkExperience>> getAllWorkExperience(){
		return this.experienceService.getAll();
	}
	@PostMapping("/addWorkExperience")
	public Result addWorkExperience(@RequestBody WorkExperience workExperience) {
		return this.experienceService.add(workExperience);
	}
	public Result update(WorkExperience workExperience) {
		return this.experienceService.update(workExperience);
	}
}
