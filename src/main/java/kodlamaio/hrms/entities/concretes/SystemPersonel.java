package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="system_personel")
@EqualsAndHashCode(callSuper=false)
public class SystemPersonel extends User {
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;

}
