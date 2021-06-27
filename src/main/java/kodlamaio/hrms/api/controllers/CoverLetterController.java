package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;
@CrossOrigin
@RestController
@RequestMapping("/api/coverletters")
public class CoverLetterController {
	private CoverLetterService coverLetterService;
	@Autowired
	public CoverLetterController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}

	@GetMapping("/getAllCoverLetter")
	public DataResult<List<CoverLetter>> getALL() {
		return this.coverLetterService.getALL();
	}
	@PostMapping("/addCoverLetter")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}
	@PostMapping("/update")
	public Result update(int id, int userId, String coverLetter) {
		return this.coverLetterService.update(id, userId, coverLetter);
	}
	
}
