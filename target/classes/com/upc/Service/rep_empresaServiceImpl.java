package com.upc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.rep_empresa;
import com.upc.Repository.rep_empresaRepository;

@Service
public class rep_empresaServiceImpl implements rep_empresaService
{
	@Autowired
	private rep_empresaRepository EmpRep;
	
	@Override
	public rep_empresa save(rep_empresa r) 
	{
		// TODO Auto-generated method stub
		return EmpRep.save(r);
	}

	@Override
	public Iterable<rep_empresa> listAllRepEmpresas() 
	{
		// TODO Auto-generated method stub
		return EmpRep.findAll();
	}

	@Override
	public void deleteRepEmpresa(int id) 
	{
		// TODO Auto-generated method stub
		EmpRep.delete(id);
	}

	@Override
	public rep_empresa getRepById(int id) 
	{
		// TODO Auto-generated method stub
		return EmpRep.findOne(id);
	}
}
