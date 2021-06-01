package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithEmployerAndJobPositionDto {
	private int id;
	private String company_name;
	private String position_name;
	private int numberOfPositions;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;
}
