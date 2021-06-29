package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TypeOfTeachingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.TypeOfTeaching;
@RequestMapping("/api/typeOfTeaching")
@RestController
@CrossOrigin
public class TypeOfTeachingController {
	private TypeOfTeachingService typeOfTeachingService;
	@Autowired
	public TypeOfTeachingController(TypeOfTeachingService typeOfTeachingService) {
		super();
		this.typeOfTeachingService = typeOfTeachingService;
	}
	@GetMapping("/getAll")
	public DataResult<List<TypeOfTeaching>> getAll() {
		return this.typeOfTeachingService.getAll();
	}
	
}
