package kodlamaio.hrms.core.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.abstracts.EmailVerificationService;
@Component
@Primary

public class EmailCheckManager implements EmailVerificationService {

	@Override
	public boolean emailVarification(String email) {
		return true;
	}

}
