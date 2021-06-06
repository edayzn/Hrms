package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import kodlamaio.hrms.core.entities.Photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cv")
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	@OneToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne()
	@JoinColumn(name="photo_id")
	private Photo photo;
	
	@OneToOne()
	@JoinColumn(name="cover_letter_id")
	private CoverLetter coverLetter;
	
	@ManyToOne()
	@JoinColumn(name="education_id")
	private EducationInformation educationInformation;
	
	@ManyToOne()
	@JoinColumn(name="experience_id")
	private WorkExperience experinces;
	
	@ManyToOne()
	@JoinColumn(name="language_id")
	private ForeignLanguageInformation languageInformation;
	
	@OneToOne()
	@JoinColumn(name = "computer_id")
	private ComputerSkill computerSkill;
	
	@ManyToOne()
	@JoinColumn(name = "social_id")
	private SocialAccount accounts; 
	
}
