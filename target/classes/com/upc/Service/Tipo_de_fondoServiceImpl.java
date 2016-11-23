package com.upc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.Tipo_de_fondo;
import com.upc.Repository.Tipo_de_fondoRepository;
@Service
public class Tipo_de_fondoServiceImpl implements Tipo_de_fondoService {
@Autowired
private Tipo_de_fondoRepository tipodefondorep;

	@Override
	public Iterable<Tipo_de_fondo> listartodos() {
		// TODO Auto-generated method stub
		return tipodefondorep.findAll();
	}

	@Override
	public Tipo_de_fondo crear(Tipo_de_fondo t) {
		// TODO Auto-generated method stub
		return tipodefondorep.save(t);
	}

	@Override
	public Tipo_de_fondo getbyid(int id) {
		// TODO Auto-generated method stub
		return tipodefondorep.findOne(id);
	}

}
