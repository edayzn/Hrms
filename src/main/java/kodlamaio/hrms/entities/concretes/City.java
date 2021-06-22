package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInformations","experiences"})
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="city_name")
	private String ctyName;
	
	@ManyToOne()
	@JoinColumn(name = "country_id")
	private Country country;
	@JsonIgnore
	@OneToMany(mappedBy ="city")
	private List<EducationInformation> educationInformations;
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private List<WorkExperience> experiences;
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private List<JobAdvertisement> advertisements;
}
