package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CountryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CountryDao;
import kodlamaio.hrms.entities.concretes.Country;
@Service
public class CountryManager implements CountryService {
	private CountryDao countryDao;
	@Autowired
	public CountryManager(CountryDao countryDao) {
		super();
		this.countryDao = countryDao;
	}
	@Override
	public DataResult<List<Country>> getAll() {
		
		return new SuccessDataResult<List<Country>>(this.countryDao.findAll(),"Ülkeler listelendi");
	}
	
	
}
