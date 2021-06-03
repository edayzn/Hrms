package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ForeignLanguageInformation;

public interface ForeignLanguageInformationDao extends JpaRepository<ForeignLanguageInformation, Integer> {

}
