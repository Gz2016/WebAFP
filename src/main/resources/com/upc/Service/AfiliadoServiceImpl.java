package com.upc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.Afiliado;
import com.upc.Repository.AfiliadoRepository;

@Service
public class AfiliadoServiceImpl implements AfiliadoService{
@Autowired
private AfiliadoRepository afiliadorep;
	@Override
	public Iterable<Afiliado> listartodos() {
		// TODO Auto-generated method stub
		return afiliadorep.findAll();
	}

	@Override
	public Iterable<Afiliado> listarpornfondo(String nfondo) {
		// TODO Auto-generated method stub
		return afiliadorep.findByNFondo(nfondo);
	}

	@Override
	public Iterable<Afiliado> listarporcfondo(int cTipofondo) {
		// TODO Auto-generated method stub
		return afiliadorep.findByCTipoFondo(cTipofondo);
	}

	@Override
	public Iterable<Afiliado> listarporrangosueldo(double s1, double s2) {
		// TODO Auto-generated method stub
		return afiliadorep.findBySueldo(s1, s2);
	}

	@Override
	public Iterable<Afiliado> listarporrangodeinteresdeaporte(double m1, double m2) {
		// TODO Auto-generated method stub
		return afiliadorep.findByMontointeres(m1, m2);
	}

	@Override
	public Iterable<Afiliado> listarpordiasdemoramayora(int qdias) {
		// TODO Auto-generated method stub
		return afiliadorep.findByDiasdeMoraGreatherThan(qdias);
	}

	@Override
	public Afiliado crear(Afiliado a) {
		// TODO Auto-generated method stub
		return afiliadorep.save(a);
	}

	@Override
	public Afiliado getporcafiliado(int cafiliado) {
		// TODO Auto-generated method stub
		return afiliadorep.findOne(cafiliado);
	}

}
