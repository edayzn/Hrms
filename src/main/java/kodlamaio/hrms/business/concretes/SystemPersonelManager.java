package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemPersonelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonelDao;
import kodlamaio.hrms.entities.concretes.SystemPersonel;
@Service
public class SystemPersonelManager implements SystemPersonelService {
	private SystemPersonelDao personelDao;
	
	@Autowired
	public SystemPersonelManager(SystemPersonelDao personelDao) {
		super();
		this.personelDao = personelDao;
	}

	@Override
	public DataResult<List<SystemPersonel>> getAll() {
		return new SuccessDataResult<List<SystemPersonel>>(this.personelDao.findAll(),"Personel listelendi");
	}

	@Override
	public Result add(SystemPersonel personel) {
		this.personelDao.save(personel);
		return new SuccessResuslt("Kayıt Başarılı!");
	}

}
