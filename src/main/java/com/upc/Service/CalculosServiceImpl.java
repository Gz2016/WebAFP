package com.upc.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculosServiceImpl implements CalculosService {
	
public static double aporte=0.1;
	
	@Override
	public double calcular_rentabilidad_mensual(double rentanual) {
		double rentmensual=Math.pow(1+rentanual,30.0/360)-1;
		return rentmensual;
	}
	
	@Override
	public double calcular_fondo_comision_flujo(double rentmensual, double fondo, double sueldo) {
		double fondoactual=fondo*(1+rentmensual)+sueldo*aporte;
		return fondoactual;
	}

	@Override
	public double calcular_comision_flujo(double cpf, double sueldo) {
		double comisionflujo=sueldo*cpf;
		return comisionflujo;
	}

	@Override
	public double calcular_fondo_o_saldo_comision_saldo(double rentmensual, double fondo_o_saldo, double sueldo, double ultimacomisionsaldo) {
		double fondo_o_saldoactual=fondo_o_saldo*(1+rentmensual)+sueldo*aporte-ultimacomisionsaldo;
		return fondo_o_saldoactual;
	}

	@Override
	public double calcular_comision_saldo(double cps, double saldo) {
		double ultimacomisionsaldo=saldo*cps/12;
		return ultimacomisionsaldo;
	}
	
	@Override
	public double calcular_porcentaje_flujo_comision_mixto(int cantmeses) {
		double porcentaje;
		if(cantmeses<=15) porcentaje=0.7;
		else if(cantmeses<=39) porcentaje=0.5;
		else if(cantmeses<=75) porcentaje=0.2;
		else porcentaje=0;
		return porcentaje;
	}
	
	@Override
	public double calcular_pension(double rentmensual, double fondo, double cantmeses) {
		double pension=(rentmensual*fondo*Math.pow(1+rentmensual,cantmeses))/(Math.pow(1+rentmensual,cantmeses)-1);
		return pension;
	}

	@Override
	public double redondear(double d) {
		d = d*100;
		d = (double) Math.round(d);
		return d /100;
	}

}
