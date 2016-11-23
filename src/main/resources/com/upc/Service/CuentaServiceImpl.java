package com.upc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.Cuenta;
import com.upc.Repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService
{
	@Autowired
	private CuentaRepository cuentarep;

	@Override
	public Iterable<Cuenta> listartodos() {
		// TODO Auto-generated method stub
		return cuentarep.findAll();
	}

	@Override
	public Iterable<Cuenta> listarporsueldodeafiliado(double s1, double s2) {
		// TODO Auto-generated method stub
		return cuentarep.findBySueldoAfiliado(s1, s2);
	}

	@Override
	public Iterable<Cuenta> listarporCafiliado(int cafiliado) {
		// TODO Auto-generated method stub
		return cuentarep.findByCAfiliado(cafiliado);
	}

	@Override
	public Iterable<Cuenta> listarporrangofondoacumulado(double f1, double f2) {
		// TODO Auto-generated method stub
		return cuentarep.findByFondo(f1,f2);
	}

	@Override
	public Cuenta crear(Cuenta c) {
		// TODO Auto-generated method stub
		return cuentarep.save(c);
	}

	@Override
	public double calcular_fondo_actual(Cuenta c) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public double calcular_fondo_futuro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cuenta getCuentaporCcuenta(int ccuenta) {
		// TODO Auto-generated method stub
		return cuentarep.findOne(ccuenta);
	}
}
