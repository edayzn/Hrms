package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EducationInformation;
@RequestMapping("/educationInformation")
@RestController
@CrossOrigin
public class EducationInformationController {

	private EducationInformationService educationInformationService;
	
	@Autowired
	public EducationInformationController(EducationInformationService educationInformationService) {
		super();
		this.educationInformationService = educationInformationService;
	}
	
	@GetMapping("/getAllEducationInformation")
	public DataResult<List<EducationInformation>> getAllEducationInformation(){
		return this.educationInformationService.getAll();
	}
	@PostMapping("/addEducationInformation")
	public Result addEducationInformation(@RequestBody EducationInformation educationInformation) {
		return this.educationInformationService.add(educationInformation);
	}
}
