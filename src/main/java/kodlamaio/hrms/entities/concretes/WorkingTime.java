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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="working_times")
public class WorkingTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "working_id")
	private int workingId;
	
	@Column(name="working_name")
	private String workingName;
	@JsonIgnore()
	@OneToMany(mappedBy = "workingTime")
	private List<JobAdvertisement> advertisements; 
	
}
