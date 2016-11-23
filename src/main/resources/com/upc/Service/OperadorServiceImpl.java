package com.upc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.Operador;
import com.upc.Repository.OperadorRepository;

@Service
public class OperadorServiceImpl implements OperadorService {

@Autowired
private OperadorRepository operadorrep;

	@Override
	public Iterable<Operador> listAll() {
		// TODO Auto-generated method stub
		return operadorrep.findAll();
	}

	@Override
	public Iterable<Operador> findByNnombresAsc(String nnombres) {
		// TODO Auto-generated method stub
		return operadorrep.findByNnombresAsc(nnombres);
	}

	@Override
	public Iterable<Operador> findByNapellidosAsc(String napellidos) {
		// TODO Auto-generated method stub
		return operadorrep.findByNapellidosAsc(napellidos);
	}

	@Override
	public Iterable<Operador> finByDni(int dni) {
		// TODO Auto-generated method stub
		return operadorrep.finByDni(dni);
	}

	@Override
	public Operador crear(Operador o) {
		// TODO Auto-generated method stub
		return operadorrep.save(o);
	}

	@Override
	public Operador getporcoperador(int coperador) {
		// TODO Auto-generated method stub
		return operadorrep.findOne(coperador);
	}

}
