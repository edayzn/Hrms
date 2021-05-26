package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.MernisService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	private JobSeekerDao jobSeekerDao;
	private MernisService mernisService;
	private EmailVerificationService emailVerificationService;
	private EmailSendService emailSendService;

	private List<String> emails = new ArrayList<>();
	private List<String> nationalityIds = new ArrayList<>();

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisService mernisService,
			EmailVerificationService emailVerificationService, EmailSendService emailSendService) {

		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisService = mernisService;
		this.emailVerificationService = emailVerificationService;
		this.emailSendService = emailSendService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Job seeker list");
	}

	@Override
	public Result add(JobSeeker jobSeeker, String passwordAgain) {
		Result result = new ErrorResult("Girilen bilgilerin doğru olduğuna emin olunuz!");
		if (emailVerificationService.emailVarification(jobSeeker.getE_mail()) && emailIsItUsed(jobSeeker.getE_mail())
				&& nationalityIdIsItUsed(jobSeeker.getIdentification_number()) && mernisService.verification(jobSeeker)
				&& Objects.equal(passwordAgain, jobSeeker.getPassword())) {
			emailSendService.emailSend(jobSeeker.getE_mail());
			this.jobSeekerDao.save(jobSeeker);
			result = new SuccessResuslt("Kayıt Başarılı.");

		} /*
			 * else { result= new
			 * ErrorResult("Girilen bilgilerin doğru olduğuna emin olunuz."); }
			 */
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
		for (JobSeeker jobSeeker : getAll().getData()) {
			emails.add(jobSeeker.getE_mail());
		}
		return emails;
	}

	public boolean nationalityIdIsItUsed(String nationalityId) {
		boolean result = true;
		if (getAllNationalityId().contains(nationalityId)) {
			result = false;
		}
		return result;
	}

	@Override
	public List<String> getAllNationalityId() {
		for (JobSeeker jobSeeker : getAll().getData()) {
			nationalityIds.add(jobSeeker.getIdentification_number());
		}
		return nationalityIds;
	}

}
