package com.app.estacionamiento.service;
import java.util.List;

import com.app.estacionamiento.entities.Auto;

public interface IAutoService {
	
	public List<Auto> findAllOrderedByMatricula();
	public void save(Auto auto);

}
