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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="work_experiences")
public class WorkExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="experience_id")
	private int experienceId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name="working_status")
	private String workingStatus;
	
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name="position_id")
	private JobPositions position;
	
	@ManyToOne()
	@JoinColumn(name = "sector_id")
	private Sector sector;
	
	
	@ManyToOne()
	@JoinColumn(name="country_id")
	private Country country;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToMany(mappedBy = "experinces")
	private List< Cv>  cvs;
}
