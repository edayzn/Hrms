package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguageInformation;

public interface ForeignLanguageInformationService {

	DataResult<List<ForeignLanguageInformation>> getAll(); 
	Result add(ForeignLanguageInformation languageInformation);
}
