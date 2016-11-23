package com.upc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.solicitud_retiro;
import com.upc.Repository.solicitud_retiroRepository;

@Service
public class solicitud_retiroImpl implements solicitud_retiroService{

	@Autowired
	solicitud_retiroRepository solicitudrepositorio;
	
	@Override
	public solicitud_retiro savesolicitud(solicitud_retiro sr) {
		// TODO Auto-generated method stub
		return solicitudrepositorio.save(sr);
	}

	@Override
	public Iterable<solicitud_retiro> findall() {
		// TODO Auto-generated method stub
		return solicitudrepositorio.findAll();
	}

	@Override
	public solicitud_retiro getsolicitudById(int id) {
		// TODO Auto-generated method stub
		return solicitudrepositorio.findOne(id);
	}

	@Override
	public void deletesolicitud(int id) {
		// TODO Auto-generated method stub	
	 solicitudrepositorio.delete(id);
	}

	@Override
	public Iterable<solicitud_retiro> findsolicitudByIdOperador(int id) {
		// TODO Auto-generated method stub
		/*return solicitudrepositorio.findsolicitudByIdOperador(id);*/
		return null;
	}

	@Override
	public Iterable<solicitud_retiro> findsolicitudByIdAfiliado(int id) {
		// TODO Auto-generated method stub
		return solicitudrepositorio.findsolicitudByIdAfiliado(id);
	}

}
