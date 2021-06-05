package kodlamaio.hrms.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.entities.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {
	@Query("Select user.user_id  From Photo")
	List<Integer> getAllUserId();
	@Modifying
	@Query("update Photo p set p.photoUrl=:url where user.user_id=:user_id")
	int updatePhotoSetPhotoUrlForUser(@Param("url") String url,@Param("user_id") int user_id);
	
	/*
	 * @Query("delete from Photo  where user.user_id=:user_id") int
	 * deletePhotoByUser(int user_id);
	 */
}
