package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EpisodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Episode;
@RequestMapping("/api/episodes")
@RestController
@CrossOrigin
public class EpisodeController {
	private EpisodeService episodeService;
	@Autowired
	public EpisodeController(EpisodeService episodeService) {
		super();
		this.episodeService = episodeService;
	}
	@GetMapping("/getAll")
	public DataResult<List<Episode>> getAll() {
		return this.episodeService.getAll();
	}
}
