package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialAccountService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.SocialAccountDao;
import kodlamaio.hrms.entities.concretes.SocialAccount;
@Service
public class SocialAccountManager implements SocialAccountService {

	private SocialAccountDao accountDao;
	
	@Autowired
	public SocialAccountManager(SocialAccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}

	@Override
	public DataResult<List<SocialAccount>> getAll() {
		return new SuccessDataResult<List<SocialAccount>>(this.accountDao.findAll(),"Sosyal hesap bilgileri listelendi");
	}

	@Override
	public Result add(SocialAccount account) {
		this.accountDao.save(account);
		return new SuccessResuslt("Sosyal hesap bilgileri eklendi.");
	}

	@Override
	public Result update(int id, int userId, String socialAccount) {
		this.accountDao.update(id, userId, socialAccount);
		return new SuccessResuslt("Sosyal hesap bilgileri güncellendi");
	}

}
