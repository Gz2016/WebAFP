package com.upc.Service;

import com.upc.Entities.rep_empresa;

public interface rep_empresaService 
{
	rep_empresa save(rep_empresa r);
	Iterable<rep_empresa> listAllRepEmpresas();
	rep_empresa getRepById(int id);
	void deleteRepEmpresa(int id);
}
