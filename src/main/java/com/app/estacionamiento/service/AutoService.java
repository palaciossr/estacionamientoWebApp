package com.app.estacionamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.estacionamiento.dao.IAutoDao;
import com.app.estacionamiento.entities.Auto;

@Service
public class AutoService implements IAutoService{
	
	@Autowired
	IAutoDao autoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Auto> findAllOrderedByMatricula() {
		return autoDao.findAllOrderedByMatricula();
		
	}

	@Override
	@Transactional
	public void save(Auto auto) {
		autoDao.save(auto);
		
	}

	@Override
	@Transactional
	public Auto actualizarAuto(Auto auto) {
		return autoDao.save(auto);
	}

	@Override
	@Transactional(readOnly = true)
	public Auto obtenerAutoPorMatricula(String matricula) {
		 return autoDao.findById(matricula).orElse(null);
	}

	@Override
	public void eliminarAuto(Auto auto) {
		// TODO Auto-generated method stub
		
	}


}
