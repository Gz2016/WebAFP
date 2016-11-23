package com.upc.Service;

import com.upc.Entities.Periododeaporte;

public interface PeriododeaporteService {
//BD:
	Iterable<Periododeaporte> listartodos();
	Iterable<Periododeaporte> listarporCafiliado(int cafiliado);
	Iterable<Periododeaporte> listarporFpagoyCafiliado(int cafiliado, String fpago);
	Iterable<Periododeaporte> listarporFpago(String fpago);
	Periododeaporte crear (Periododeaporte p);
	Periododeaporte getPeriododeaportebyid(int id);
}
