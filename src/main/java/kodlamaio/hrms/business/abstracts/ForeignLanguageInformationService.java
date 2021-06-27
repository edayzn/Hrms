package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguageInformation;

public interface ForeignLanguageInformationService {

	DataResult<List<ForeignLanguageInformation>> getAll(); 
	Result add(ForeignLanguageInformation languageInformation);
	Result update(@Param("id") int id, @Param("userId") int userId, @Param("levelId") int levelId, @Param("languageId") int languageId);
}
