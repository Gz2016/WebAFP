package com.upc.Service;

import com.upc.Entities.solicitud_retiro;

public interface solicitud_retiroService {

	solicitud_retiro savesolicitud(solicitud_retiro sr);
	Iterable<solicitud_retiro> findall();
	solicitud_retiro getsolicitudById(int id);
	void deletesolicitud(int id);
	Iterable<solicitud_retiro> findsolicitudByIdOperador(int id);
	Iterable<solicitud_retiro> findsolicitudByIdAfiliado(int id);
	
}
