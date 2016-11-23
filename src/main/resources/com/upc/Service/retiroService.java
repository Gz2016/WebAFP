package com.upc.Service;



import com.upc.Entities.retiro;



public interface retiroService {

	 retiro saveretiro(retiro r);
	 Iterable<retiro> findall();
	 retiro getretiroById(int id);
	 void deleteretiro(int id);
	 retiro getretiroBySolicitud(int id);
	 Iterable<retiro> getretiroByCuenta(int id);
	 double calcularmontoretiro(retiro r);
}
