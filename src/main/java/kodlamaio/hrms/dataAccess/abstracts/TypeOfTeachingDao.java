package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.TypeOfTeaching;

public interface TypeOfTeachingDao extends JpaRepository<TypeOfTeaching, Integer> {

}
