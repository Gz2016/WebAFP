package com.upc.Service;

import com.upc.Entities.Afiliado;

public interface AfiliadoService {
	
	//METODOS QUE REQUIEREN ACCESO A BD
	Iterable<Afiliado> listartodos();
	Iterable<Afiliado> listarpornfondo(String nfondo);
	Iterable<Afiliado> listarporcfondo(int cTipofondo);
	Iterable<Afiliado> listarporrangosueldo(double s1,double s2);
	Iterable<Afiliado> listarporrangodeinteresdeaporte(double m1,double m2);
	Iterable<Afiliado> listarpordiasdemoramayora(int qdias);
	Afiliado getporcafiliado(int cafiliado);
	Afiliado crear(Afiliado a);
	//METODOS QUE NO REQUIEREN ACCESO A BD

	
}
