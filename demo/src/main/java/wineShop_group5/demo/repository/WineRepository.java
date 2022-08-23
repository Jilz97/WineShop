package wineShop_group5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wineShop_group5.demo.model.Wine;



public interface WineRepository extends JpaRepository<Wine ,Integer>{
	
}
