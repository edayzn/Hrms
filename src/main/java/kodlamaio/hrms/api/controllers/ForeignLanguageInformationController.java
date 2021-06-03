package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguageInformation;

@RestController
@RequestMapping("/api/languageInformation")
public class ForeignLanguageInformationController {

	private ForeignLanguageInformationService languageInformationService;
	@Autowired
	public ForeignLanguageInformationController(ForeignLanguageInformationService languageInformationService) {
		super();
		this.languageInformationService = languageInformationService;
	}
	@GetMapping("/getAll")
	public DataResult<List<ForeignLanguageInformation>> getAll() {
		return this.languageInformationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguageInformation languageInformation) {
		return this.languageInformationService.add(languageInformation);
	}
	
	
}
