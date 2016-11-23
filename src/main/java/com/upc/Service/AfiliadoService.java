package com.upc.Service;

import com.upc.Entities.Afiliado;

public interface AfiliadoService {
	
	//METODOS QUE REQUIEREN ACCESO A BD
	Afiliado autenticar(String dni, String contrasena);
	Afiliado crear(Afiliado a);
	Afiliado findAfiliado(int cafiliado);
	Afiliado findByDni(String dni);
	//METODOS QUE NO REQUIEREN ACCESO A BD

	
}
