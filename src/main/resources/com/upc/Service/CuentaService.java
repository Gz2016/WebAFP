package com.upc.Service;

import com.upc.Entities.Cuenta;

public interface CuentaService {
	//BD:
	Iterable<Cuenta> listartodos();
	Iterable<Cuenta> listarporsueldodeafiliado(double s1, double s2);
	Iterable<Cuenta> listarporCafiliado(int cafiliado);
	Iterable<Cuenta> listarporrangofondoacumulado(double f1,double f2);
	Cuenta crear(Cuenta c);
	Cuenta getCuentaporCcuenta(int ccuenta);
	//NO BD:
	double calcular_fondo_actual(Cuenta c);//PENDIENTE
	double calcular_fondo_futuro();//PENDIENTE
}
