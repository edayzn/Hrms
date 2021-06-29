package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TypeOfTeachingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.TypeOfTeachingDao;
import kodlamaio.hrms.entities.concretes.TypeOfTeaching;
@Service
public class TypeOfTeachingManager implements TypeOfTeachingService {
	private TypeOfTeachingDao typeOfTeachingDao;
	@Autowired
	public TypeOfTeachingManager(TypeOfTeachingDao typeOfTeachingDao) {
		super();
		this.typeOfTeachingDao = typeOfTeachingDao;
	}

	@Override
	public DataResult<List<TypeOfTeaching>> getAll() {
		
		return new SuccessDataResult<List<TypeOfTeaching>>(this.typeOfTeachingDao.findAll());
	}

}
