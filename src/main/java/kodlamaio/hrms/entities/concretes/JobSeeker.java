package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;



import javax.persistence.Table;

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
public class JobSeeker extends User {

	@Column(name="first_name")
	 private String firstname;
	
	@Column(name="last_name")
	 private String lastname;
	
	@Column(name="identification_number")
	 private String identification_number;
	
	@Column(name="year_of_birth")
	 private int yearOfBirth;
	 
}
