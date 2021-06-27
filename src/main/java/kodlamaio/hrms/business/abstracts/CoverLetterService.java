package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	DataResult<List<CoverLetter>> getALL();
	Result add(CoverLetter coverLetter);
	Result update(@Param("id") int id,@Param("userId") int userId,@Param("coverLetter") String coverLetter);
}
