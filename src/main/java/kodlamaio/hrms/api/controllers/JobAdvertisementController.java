package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
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
	public DataResult<List<JobAdvertisement>> findAllActiveJob_Advertisements(){
		return this.advertisementService.findAllActiveJob_Advertisements();
	}
	@GetMapping("/getByJobIdAndEmployer")
	public DataResult<JobAdvertisement> getByJobIdAndEmployer(@RequestParam int job_id, @RequestParam int employer_id){
		return this.advertisementService.getByJobIdAndEmployer(job_id, employer_id);
	}
	@GetMapping("/updateJobActive")
	public DataResult<Integer> updateJobAdvertisementSetWorkingConditionForEmployer(@RequestParam int jobId, @RequestParam int employer_id){
		return this.advertisementService.updateJobAdvertisementSetWorkingConditionForEmployer(jobId, employer_id);
	}
}
