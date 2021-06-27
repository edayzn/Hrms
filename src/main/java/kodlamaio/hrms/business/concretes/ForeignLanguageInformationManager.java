package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageInformationDao;
import kodlamaio.hrms.entities.concretes.ForeignLanguageInformation;
@Service
public class ForeignLanguageInformationManager implements ForeignLanguageInformationService {

	private ForeignLanguageInformationDao languageInformationDao;
	@Autowired
	public ForeignLanguageInformationManager(ForeignLanguageInformationDao languageInformationDao) {
		super();
		this.languageInformationDao = languageInformationDao;
	}

	@Override
	public DataResult<List<ForeignLanguageInformation>> getAll() {
		
		return new SuccessDataResult<List<ForeignLanguageInformation>>(this.languageInformationDao.findAll()," Yabancı dil bilgisi listelendi.");
	}

	@Override
	public Result add(ForeignLanguageInformation languageInformation) {
		this.languageInformationDao.save(languageInformation);
		return new SuccessResuslt(" Yabancı dil bilgisi eklendi.");
	}

	@Override
	public Result update(int id, int userId,int levelId ,int languageId) {
		this.languageInformationDao.update(id, userId,levelId, languageId);
		return new SuccessResuslt("Yabancı dil bilgisi güncellendi");
	}

}
