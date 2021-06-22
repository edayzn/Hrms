package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements"})
public class Employer extends User {
	
	@Column(name="company_name")
	 private String company_name;
	
	@Column(name="web_site")
	 private String web_site;
	
	@Column(name="phone")
	 private String phone;
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> advertisements;
}
