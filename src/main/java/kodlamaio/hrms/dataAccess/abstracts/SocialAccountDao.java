package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.SocialAccount;

public interface SocialAccountDao extends JpaRepository<SocialAccount, Integer> {
	@Modifying
	@Query("update SocialAccount set socialAccount=:socialAccount where jobSeeker.user_id=:userId and id=:id")
	int update(@Param("id")int id, @Param("userId") int userId,@Param("socialAccount") String socialAccount);
}
