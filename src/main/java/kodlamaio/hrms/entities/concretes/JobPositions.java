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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity 
@Table(name="job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements","experiences"})
public class JobPositions {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
	 private int id;
	
	@Column(name="position_name")
	 private String position_name;
	@JsonIgnore
	@OneToMany(mappedBy ="jobPosition")
	private List<JobAdvertisement> advertisements;
	@JsonIgnore
	@OneToMany(mappedBy = "position")
	private List<WorkExperience> experiences;
	
}
