package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ComputerSkillService;
import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.business.abstracts.ForeignLanguageInformationService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.SocialAccountService;
import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ComputerSkill;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.concretes.ForeignLanguageInformation;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.SocialAccount;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;
	private EducationInformationService educationInformationService;
	private WorkExperienceService experienceService;
	private ForeignLanguageInformationService languageInformationService;
	private SocialAccountService accountService;
	private CoverLetterService coverLetterService;
	private ComputerSkillService computerSkillService;
	private CvService cvService;
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService,
			EducationInformationService educationInformationService, WorkExperienceService experienceService,
			ForeignLanguageInformationService languageInformationService, SocialAccountService accountService,
			CoverLetterService coverLetterService, ComputerSkillService computerSkillService, CvService cvService) {
		super();
		this.jobSeekerService = jobSeekerService;
		this.educationInformationService = educationInformationService;
		this.experienceService = experienceService;
		this.languageInformationService = languageInformationService;
		this.accountService = accountService;
		this.coverLetterService=coverLetterService;
		this.computerSkillService=computerSkillService;
		this.cvService=cvService;
	}
	

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>>  getAll() {
		return this.jobSeekerService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker, String passwordAgain) {
		return this.jobSeekerService.add(jobSeeker,passwordAgain);
	}
	
	@GetMapping("/getAllEducationInformation")
	public DataResult<List<EducationInformation>> getAllEducationInformation(){
		return this.educationInformationService.getAll();
	}
	@PostMapping("/addEducationInformation")
	public Result addEducationInformation(@RequestBody EducationInformation educationInformation) {
		return this.educationInformationService.add(educationInformation);
	}
	@GetMapping("/getAllWorkExperience")
	public DataResult<List<WorkExperience>> getAllWorkExperience(){
		return this.experienceService.getAll();
	}
	@PostMapping("/addWorkExperience")
	public Result addWorkExperience(@RequestBody WorkExperience workExperience) {
		return this.experienceService.add(workExperience);
	}

	@GetMapping("/getAllForeignLanguageInformation")
	public DataResult<List<ForeignLanguageInformation>> getAllForeignLanguageInformation() {
		return this.languageInformationService.getAll();
	}
	
	@PostMapping("/addForeignLanguageInformation")
	public Result addForeignLanguageInformation(@RequestBody ForeignLanguageInformation languageInformation) {
		return this.languageInformationService.add(languageInformation);
	}
	@GetMapping("/getAllSocialAccount")
	public DataResult<List<SocialAccount>> getAllSocialAccount() {
		return this.accountService.getAll();
	}
	@PostMapping("/addSocialAccount")
	public Result addSocialAccount(@RequestBody SocialAccount account) {
		return this.accountService.add(account);
	}
	
	@GetMapping("/getAllCoverLetter")
	public DataResult<List<CoverLetter>> getALLCoverLetter() {
		return this.coverLetterService.getALL();
	}
	@PostMapping("/addCoverLetter")
	public Result addCoverLetter(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}
	@GetMapping("/getAllComputerSkill")
	public DataResult<List<ComputerSkill>> getAllComputerSkill() {
		return this.computerSkillService.getAll();
	}
	@PostMapping("/addComputerSkill")
	public Result addComputerSkill(@RequestBody ComputerSkill computerSkill) {
		return this.computerSkillService.add(computerSkill);
	}
	@PostMapping("/addCv")
	public Result addCv(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}
}
