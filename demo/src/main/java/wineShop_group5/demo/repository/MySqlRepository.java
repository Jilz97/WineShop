package wineShop_group5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wineShop_group5.demo.model.winery;


public interface MySqlRepository extends JpaRepository<winery,Integer>{
	

}
