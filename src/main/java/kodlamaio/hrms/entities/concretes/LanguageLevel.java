package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="language_levels")
public class LanguageLevel {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="level_id")
	private int levelId;
	
	@Column(name = "level_name")
	private String levelName;
}
