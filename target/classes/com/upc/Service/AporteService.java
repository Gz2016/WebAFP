package com.upc.Service;

import com.upc.Entities.Aporte;

public interface AporteService {
	
	//BD:
	Iterable<Aporte> listartodos();
	Iterable<Aporte> listarporrangodefechapago(String f1, String f2);
	Iterable<Aporte> listarporcuentayrangofechadepago(int ccuenta,String f1, String f2);
	Iterable<Aporte> listarporrangodemontoaporte(double m1,double m2);
	Iterable<Aporte> listarporcuenta(int ccuenta);
	Aporte crear(Aporte a);
	Aporte getporcaporte(int caporte);
	//NO BD:
	double calculo_monto_aporte(Aporte a,double aportevoluntario);
}
