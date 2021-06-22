package kodlamaio.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResuslt;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTpyeDao;
import kodlamaio.hrms.entities.concretes.WorkingType;
@Service
public class WorkingTypeManager implements WorkingTypeService {

	private WorkingTpyeDao workingTypeDao;
	
	@Autowired
	public WorkingTypeManager(WorkingTpyeDao workingTypeDao) {
		super();
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		return new SuccessDataResult<List<WorkingType>>(this.workingTypeDao.findAll(),"Çalışma Türleri Listelendi..");
	}

	@Override
	public Result add(WorkingType workingType) {
		this.workingTypeDao.save(workingType);
		return new SuccessResuslt("Kayıt Başarılı");
	}

}
