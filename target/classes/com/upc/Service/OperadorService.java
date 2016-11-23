package com.upc.Service;

import com.upc.Entities.Operador;

public interface OperadorService {
	
	Iterable<Operador> listAll();
	
	Iterable<Operador> findByNnombresAsc(String nnombres);
	
	Iterable<Operador> findByNapellidosAsc(String napellidos);
	
	Iterable<Operador> finByDni(int dni);

	Operador crear(Operador o);
	Operador getporcoperador(int coperador);
}
