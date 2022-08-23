package wineShop_group5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wineShop_group5.demo.model.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine,Integer>{
	
}
