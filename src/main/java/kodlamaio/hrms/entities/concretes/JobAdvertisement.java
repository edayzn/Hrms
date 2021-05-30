package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="job_advertisement")

public class JobAdvertisement {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_id")
	private int jobId;
	
	@Column(name="job_description")
	private String job_description;
	
	@Column(name="city")
	private String city;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="number_of_positions")
	private int numberOfPositions;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name= "working_condition")
	private boolean workingCondition;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="position_id")
	private JobPositions jobPosition;
}
