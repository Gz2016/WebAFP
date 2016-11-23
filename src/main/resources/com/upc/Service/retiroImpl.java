package com.upc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.retiro;
import com.upc.Repository.retiroRepository;

@Service
public class retiroImpl implements retiroService {

	@Autowired
	retiroRepository retirorepositorio;

	@Override
	public retiro saveretiro(retiro r) {
		// TODO Auto-generated method stub
		return retirorepositorio.save(r);
	}

	@Override
	public Iterable<retiro> findall() {
		// TODO Auto-generated method stub
		return retirorepositorio.findAll();
	}

	@Override
	public retiro getretiroById(int id) {
		// TODO Auto-generated method stub
		return retirorepositorio.findOne(id);
	}

	@Override
	public void deleteretiro(int id) {
		// TODO Auto-generated method stub
		retirorepositorio.delete(id);
	}

	@Override
	public retiro getretiroBySolicitud(int id) {
		// TODO Auto-generated method stub
		return retirorepositorio.findBySolicitudRetiro(id);
	}

	@Override
	public Iterable<retiro> getretiroByCuenta(int id) {
		// TODO Auto-generated method stub
		return retirorepositorio.findByCCuenta(id);
	}
/*
	@Override
	public double calcularmontoretiro(retiro r) {
		// TODO Auto-generated method stub
		return 0;
	}
	*/

	

	@Override
	public double calcularmontoretiro(retiro r) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
