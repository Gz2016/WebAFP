package com.upc.Service;

import com.upc.Entities.Solicitud;

public interface SolicitudService {

	Solicitud saveSolicitud(Solicitud s);
	
	Solicitud findSolicitudbyid(int id);

	void deleteSolicitud(int csolicitud);
	
	Iterable<Solicitud> listSolicitudesAfiliado(int cafiliado);
	
	double calcularRentabilidad(Solicitud s);
	
	double calcularComisionPorFlujo(Solicitud s);
	
	double calcularComisionPorSaldo(Solicitud s);
	
	int calcularmeses(Solicitud s);
}
