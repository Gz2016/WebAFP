package com.upc.Service;

public interface CalculosService {
	//NO BD:
double calcular_rentabilidad_mensual(double rentanual);
	
	double calcular_fondo_comision_flujo(double rentmensual,double fondo,double sueldo);
	double calcular_comision_flujo(double cpf, double sueldo);
	
	double calcular_fondo_o_saldo_comision_saldo(double rentmensual,double fondo_o_saldo,double sueldo,double ultimacomisionsaldo);
	double calcular_comision_saldo(double cps, double saldo);
	
	double calcular_porcentaje_flujo_comision_mixto(int cantmeses);
	
	double calcular_pension(double rentmensual,double fondo,double cantmeses);
	
	double redondear(double d);
}
