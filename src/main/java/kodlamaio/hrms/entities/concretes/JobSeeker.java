package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInformations","experiences","languageInformations","accounts","coverLetter","computerSkills"})
public class JobSeeker extends User {

	@Column(name="first_name")
	 private String firstname;
	
	@Column(name="last_name")
	 private String lastname;
	
	@Column(name="identification_number")
	 private String identification_number;
	
	@Column(name="year_of_birth")
	 private int yearOfBirth;
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<EducationInformation> educationInformations;
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")	
	private List<WorkExperience> experiences;
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<ForeignLanguageInformation> languageInformations;
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<SocialAccount> accounts;
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CoverLetter> coverLetter;
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<ComputerSkill> computerSkills;
	@JsonIgnore
	@OneToOne(mappedBy = "jobSeeker")
	private Cv cv;
}
