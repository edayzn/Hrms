package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;


@Service
public class EmployerManager implements EmployerService {

	//private JobAdvertisementDao advertisementDao;
	private EmployerDao employerDao;
	private EmailSendService emailSendService;
	private List<String> emails = new ArrayList<>();

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailSendService emailSendService) {
		super();
		this.employerDao = employerDao;
		this.emailSendService = emailSendService;
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employer listed");

	}

	@Override
	public Result add(Employer employer, String passwordAgain) {
		Result result = new ErrorResult("Kayıt Başarısız!");
		if (emailIsItUsed(employer.getE_mail()) && Objects.equal(passwordAgain, employer.getPassword())) {
			emailSendService.emailSend(employer.getE_mail());
			this.employerDao.save(employer);
			return new SuccessResuslt("Employer added");
		}
		return result;
		
	}
	


	public boolean emailIsItUsed(String email) {
		boolean result = true;
		if (getEmails().contains(email)) {
			result = false;
		}
		return result;
	}

	@Override
	public List<String> getEmails() {
		for (Employer employer : getAll().getData()) {
			emails.add(employer.getE_mail());
		}

		return emails;
	}

	

}
