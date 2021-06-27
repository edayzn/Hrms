package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialAccountService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialAccount;
@RestController
@RequestMapping("/api/socialAccount")
@CrossOrigin
public class SocialAccountController {
	private SocialAccountService accountService;
	
	@Autowired
	public SocialAccountController(SocialAccountService accountService) {
		super();
		this.accountService = accountService;
	}
	@GetMapping("/getAll")
	public DataResult<List<SocialAccount>> getAll() {
		return this.accountService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody SocialAccount account) {
		return this.accountService.add(account);
	}
	@Transactional
	@PostMapping("/update")
	public Result update(int id, int userId, String socialAccount) {
		return this.accountService.update(id, userId, socialAccount);
	}
	
}
