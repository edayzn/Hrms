package kodlamaio.hrms.core.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import kodlamaio.hrms.core.abstracts.EmailVerificationService;

@Component
public class EmailVerificationManager implements EmailVerificationService{
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	@Override
	public boolean emailVarification(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).find();
	}
}
