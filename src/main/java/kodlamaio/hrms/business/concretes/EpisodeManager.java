package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EpisodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EpisodeDao;
import kodlamaio.hrms.entities.concretes.Episode;
@Service
public class EpisodeManager implements EpisodeService{

	private EpisodeDao episodeDao;
	
	@Autowired
	public EpisodeManager(EpisodeDao episodeDao) {
		super();
		this.episodeDao = episodeDao;
	}


	@Override
	public DataResult<List<Episode>> getAll() {
		
		return new SuccessDataResult<List<Episode>>(this.episodeDao.findAll(),"Bölümler listelendi");
	}

}
