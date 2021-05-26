package kodlamaio.hrms.business.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.JobSeeker;
@Service
public interface MernisService {
	   boolean verification (JobSeeker jobSeeker);
}
