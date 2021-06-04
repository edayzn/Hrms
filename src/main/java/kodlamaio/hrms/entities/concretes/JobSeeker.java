package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name="job_seekers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInformations","experiences","languageInformations","accounts"})
public class JobSeeker extends User {

	@Column(name="first_name")
	 private String firstname;
	
	@Column(name="last_name")
	 private String lastname;
	
	@Column(name="identification_number")
	 private String identification_number;
	
	@Column(name="year_of_birth")
	 private int yearOfBirth;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<EducationInformation> educationInformations;
	
	@OneToMany(mappedBy = "jobSeeker")	
	private List<WorkExperience> experiences;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<ForeignLanguageInformation> languageInformations;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<SocialAccount> accounts;
}
