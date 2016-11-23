package com.upc.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.Afiliado;
import com.upc.Repository.AfiliadoRepository;

@Service
public class AfiliadoServiceImpl implements AfiliadoService{
@Autowired
private AfiliadoRepository afiliadorep;

@Override
public Afiliado autenticar(String dni, String contrasena) {
	// TODO Auto-generated method stub
	return afiliadorep.findByDniAndContrasena(dni, contrasena);
}

@Override
public Afiliado crear(Afiliado a) {
	// TODO Auto-generated method stub
	return afiliadorep.save(a);
}

@Override
public Afiliado findAfiliado(int cafiliado) {
	// TODO Auto-generated method stub
	return afiliadorep.findOne(cafiliado);
}

@Override
public Afiliado findByDni(String dni) {
	// TODO Auto-generated method stub
	return afiliadorep.findByDni(dni);
}



}
