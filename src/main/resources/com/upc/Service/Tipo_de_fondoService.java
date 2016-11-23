package com.upc.Service;

import com.upc.Entities.Tipo_de_fondo;

public interface Tipo_de_fondoService {
//BD:
	Iterable<Tipo_de_fondo> listartodos();
	Tipo_de_fondo crear(Tipo_de_fondo t);
	Tipo_de_fondo getbyid(int id);
}
