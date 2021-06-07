package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer> {

	
	@Query("From Cv c Inner join c.jobSeeker j  where j.identification_number=:identification_number  ")
     List<Cv> findByJobSeeker(String identification_number);
}
