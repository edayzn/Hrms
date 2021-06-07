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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="education_levels")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInfromations"})
public class EducationLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_id")
	  private int educationId;
	
	@Column(name="education_name")
	  private String educationName;
	@JsonIgnore
	@OneToMany(mappedBy = "educationLevel")
	private List<EducationInformation> educationInfromations;
	
}
