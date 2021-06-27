package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialAccount;

public interface SocialAccountService {

	DataResult<List<SocialAccount>> getAll();
	Result add(SocialAccount account);
	Result update(@Param("id")int id, @Param("user_id") int userId,@Param("socialAccount") String socialAccount);
}
