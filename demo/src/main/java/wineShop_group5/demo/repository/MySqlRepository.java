package wineShop_group5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wineShop_group5.demo.model.Winery;


public interface MySqlRepository extends JpaRepository<Winery, Long>{

	
}

