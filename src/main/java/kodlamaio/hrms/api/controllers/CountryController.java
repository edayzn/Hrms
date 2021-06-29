package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CountryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Country;
@RestController
@RequestMapping("/api/countries")
@CrossOrigin
public class CountryController {
	private CountryService countryService;
	@Autowired
	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}
	public DataResult<List<Country>> getAll() {
		return this.countryService.getAll();
	}
	
}
