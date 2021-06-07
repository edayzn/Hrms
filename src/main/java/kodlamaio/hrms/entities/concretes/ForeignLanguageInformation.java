package kodlamaio.hrms.entities.concretes;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="foreign_language_information")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvs"})
public class ForeignLanguageInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name="language_id")
	private Language language;
	
	@ManyToOne()
	@JoinColumn(name="level_id")
	private LanguageLevel languageLevel;
	@JsonIgnore
	@OneToMany(mappedBy = "languageInformation")
	private List<Cv> cvs;
}