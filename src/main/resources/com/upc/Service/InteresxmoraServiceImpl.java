package com.upc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.Interesxmora;
import com.upc.Repository.InteresxmoraRepository;

@Service
public class InteresxmoraServiceImpl implements InteresxmoraService{
@Autowired
private InteresxmoraRepository interesxmorarep;
	@Override
	public Iterable<Interesxmora> listartodos() {
		// TODO Auto-generated method stub
		return interesxmorarep.findAll();
	}

	@Override
	public Interesxmora crear(Interesxmora i) {
		// TODO Auto-generated method stub
		return interesxmorarep.save(i);
	}

	@Override
	public Interesxmora getInteresxmoraporid(int cinteresxmora) {
		// TODO Auto-generated method stub
		return interesxmorarep.findOne(cinteresxmora);
	}

}
