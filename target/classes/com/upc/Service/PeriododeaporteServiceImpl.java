package com.upc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.Periododeaporte;
import com.upc.Repository.PeriododeaporteRepository;

@Service
public class PeriododeaporteServiceImpl implements PeriododeaporteService{
@Autowired
private PeriododeaporteRepository periododeaporterep;
	@Override
	public Iterable<Periododeaporte> listartodos() {
		// TODO Auto-generated method stub
		return periododeaporterep.findAll();
	}

	@Override
	public Iterable<Periododeaporte> listarporCafiliado(int cafiliado) {
		// TODO Auto-generated method stub
		return periododeaporterep.findByCAfiliado(cafiliado);
	}

	@Override
	public Iterable<Periododeaporte> listarporFpagoyCafiliado(int cafiliado, String fpago) {
		// TODO Auto-generated method stub
		return periododeaporterep.findByFpagoandCAfiliado(cafiliado, fpago);
	}

	@Override
	public Iterable<Periododeaporte> listarporFpago(String fpago) {
		// TODO Auto-generated method stub
		return periododeaporterep.findByFpago(fpago);
	}

	@Override
	public Periododeaporte crear(Periododeaporte p) {
		// TODO Auto-generated method stub
		return periododeaporterep.save(p);
	}

	@Override
	public Periododeaporte getPeriododeaportebyid(int id) {
		// TODO Auto-generated method stub
		return periododeaporterep.findOne(id);
	}

}
