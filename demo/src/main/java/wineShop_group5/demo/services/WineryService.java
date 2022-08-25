package wineShop_group5.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import wineShop_group5.demo.model.Winery;
import wineShop_group5.demo.repository.MySqlRepository;

@Service
public class WineryService {
	
	
	

	    @Autowired
	    MySqlRepository mySqlRepository;

	    public List<Winery> getAll() {
	        return mySqlRepository.findAll();
	    }

	    public Winery getById(Long id) throws NotFoundException {
	        return mySqlRepository.findById(id).orElseThrow(() -> new NotFoundException());
	    }
	    
	    public Winery save(Winery winery) {
	        return mySqlRepository.save(winery);
	    }

	    public Winery update(Winery winery) {
	        return mySqlRepository.save(winery);
	    }

	    public boolean delete(Long id) {
	    	mySqlRepository.deleteById(id);
	    	return true;
	    }
	}


