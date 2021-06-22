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
@Table(name="sectors")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","experiences"})
public class Sector {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sector_id")
	private int sectorId;
	
	@Column(name="sector_name")
	private String sectorName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sector")
	private List<WorkExperience> experiences;
}
