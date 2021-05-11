package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@Table(name="job_positions")
public class JobPositions {
	@Id
	 @GeneratedValue
	 @Column(name="id")
	 private int id;
	
	@Column(name="position_name")
	 private String position_name;

	
	
	public JobPositions(int id, String position_name) {
		super();
		this.id = id;
		this.position_name = position_name;
	}



	public JobPositions() {
		super();
	}
	
	
}
