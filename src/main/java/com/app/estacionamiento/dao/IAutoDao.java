package com.app.estacionamiento.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.estacionamiento.entities.Auto;

public interface IAutoDao extends JpaRepository<Auto, String>{
	
	@Query("SELECT a FROM Auto a ORDER BY a.matricula ASC")
    public List<Auto> findAllOrderedByMatricula();
	

}
