package kodlamaio.hrms.business.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
@Component
@Primary
public class MernisCheckManager implements MernisService{

	@Override
	public boolean verification(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return true;
	}

}
