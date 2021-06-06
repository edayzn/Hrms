package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="education_information")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvs"})
public class EducationInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_id")
	private int id;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name="education_status")
	private String educationStatus;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name="education_level_id")
	private EducationLevel educationLevel;
	
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	@ManyToOne()
	@JoinColumn(name="episode_id")
	private Episode episode;
	
	@ManyToOne()
	@JoinColumn(name="type_of_teaching_id")
	private TypeOfTeaching ofTeaching;
	
	
	@OneToMany(mappedBy = "educationInformation")
	private List<Cv> cvs;
}
