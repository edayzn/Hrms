package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerAndJobPositionDto;

@RestController
@RequestMapping("/api/jobadvertisement")
@CrossOrigin
public class JobAdvertisementController {

	private JobAdvertisementService advertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService advertisementService) {
		super();
		this.advertisementService = advertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.advertisementService.getAll();
	}
	@GetMapping("/findallActive")
	public DataResult<List<JobAdvertisement>> findByWorkingConditionTrue(){
		return this.advertisementService.findByWorkingConditionTrue();
	}
	@GetMapping("/findByRealeseDate")
	public DataResult< List<JobAdvertisement>> findByOrderByReleaseDateDesc(){
		return this.advertisementService.findByOrderByReleaseDateDesc();
	}
	
	@GetMapping("/getByJobIdAndEmployer")
	public DataResult<JobAdvertisement> findByJobIdAndEmployer(@RequestParam int job_id, @RequestParam int employer_id){
		return this.advertisementService.findByJobIdAndEmployer(job_id, employer_id);
	}
	@GetMapping("/updateJobActive")
	@Transactional
	public Result updateJobAdvertisementSetWorkingConditionForEmployer(@RequestParam int jobId, @RequestParam int employer_id){
		return this.advertisementService.updateJobAdvertisementSetWorkingConditionForEmployer(jobId, employer_id);
	}
	@GetMapping("/getJobAdvertisementWithEmployerAndJobPositionDetails")
	public DataResult<List<JobAdvertisementWithEmployerAndJobPositionDto>> getJobAdvertisementWithEmployerAndJobPositionDetails(){
		return this.advertisementService.findJobAdvertisementWithEmployerAndJobPositionDetails();
	
	}
	 
	 @PostMapping("/add")
	 public Result add(@RequestBody JobAdvertisement advertisement) {
		 return this.advertisementService.add(advertisement);
	 }
	
	
}
