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
@Table(name="type_of_teaching")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInformations"})
public class TypeOfTeaching {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="teaching_id")	
	private int teachingId;
	
	@Column(name="teaching_name")
	private String teachingName;
	@JsonIgnore
	@OneToMany(mappedBy = "ofTeaching")
	private List<EducationInformation> educationInformations;
	
}
