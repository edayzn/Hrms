package kodlamaio.hrms.core.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.EmailSendManagerAdapter;
import kodlamaio.hrms.core.abstracts.EmailSendService;
@Service
public class EmailSendManager implements EmailSendService {

	private EmailSendManagerAdapter emailSendManagerAdapter;
	@Autowired
	public EmailSendManager(EmailSendManagerAdapter emailSendManagerAdapter) {
		super();
		this.emailSendManagerAdapter = emailSendManagerAdapter;
	}

	@Override
	public void emailSend(String email) {
		emailSendManagerAdapter.emailSend(email);
		
	}

}
