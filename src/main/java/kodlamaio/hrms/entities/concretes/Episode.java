package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="episodes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInformations"})
public class Episode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="episode_id")
	private int episodeId;
	
	@Column(name="episode_name")
	private String episodeName;
	@JsonIgnore
	@OneToMany(mappedBy = "episode")
	private List<EducationInformation> educationInformations;
}
