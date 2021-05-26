package kodlamaio.hrms.business.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Component
@Service
public class MernisManager implements MernisService {

	@Override
	public boolean verification(JobSeeker jobSeeker) {

		boolean control = false;

		KPSPublicSoap kpsPublic = new KPSPublicSoapProxy();

		try {
			control = kpsPublic.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentification_number()),
					jobSeeker.getFirstname().toUpperCase(), jobSeeker.getLastname().toUpperCase(),
					jobSeeker.getYearOfBirth());
			System.out.println(control + " geldiii");
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (RemoteException e) {

			e.printStackTrace();
		}

		return control;
	}

}
