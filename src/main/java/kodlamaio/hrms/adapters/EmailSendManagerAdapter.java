package kodlamaio.hrms.adapters;

import org.springframework.stereotype.Service;

@Service
public class EmailSendManagerAdapter {
	public void emailSend(String email) {
		System.out.println(email+"  adresine doğrulama e-postası gönderildi.");
	}

}
