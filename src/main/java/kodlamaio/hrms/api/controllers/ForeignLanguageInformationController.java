package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
	
	@GetMapping("/getAllForeignLanguageInformation")
	public DataResult<List<ForeignLanguageInformation>> getAllForeignLanguageInformation() {
		return this.languageInformationService.getAll();
	}
	
	@PostMapping("/addForeignLanguageInformation")
	public Result addForeignLanguageInformation(@RequestBody ForeignLanguageInformation languageInformation) {
		return this.languageInformationService.add(languageInformation);
	}
	@Transactional
	@PostMapping("/update")
	public Result update(int id, int userId,int levelId, int languageId) {
		return this.languageInformationService.update(id, userId, levelId, languageId);
	}
}
