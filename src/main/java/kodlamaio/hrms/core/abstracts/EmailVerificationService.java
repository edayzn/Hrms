package kodlamaio.hrms.core.abstracts;

import org.springframework.stereotype.Service;

@Service
public interface EmailVerificationService {
	public boolean emailVarification(String email);
}
