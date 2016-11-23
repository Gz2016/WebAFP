package com.upc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.Aporte;
import com.upc.Repository.AporteRepository;

@Service
public class AporteServiceImpl implements AporteService{
@Autowired
private AporteRepository aporterep;
	@Override
	public Iterable<Aporte> listartodos() {
		// TODO Auto-generated method stub
		return aporterep.findAll();
	}

	@Override
	public Iterable<Aporte> listarporrangodefechapago(String f1, String f2) {
		// TODO Auto-generated method stub
		return aporterep.findByFechaPago(f1, f2);
	}

	@Override
	public Iterable<Aporte> listarporcuentayrangofechadepago(int ccuenta, String f1, String f2) {
		// TODO Auto-generated method stub
		return aporterep.findByCcuentaAndFechaPago(ccuenta, f1, f2);
	}

	@Override
	public Iterable<Aporte> listarporrangodemontoaporte(double m1, double m2) {
		// TODO Auto-generated method stub
		return aporterep.findByMontoaporte(m1, m2);
	}

	@Override
	public Aporte crear(Aporte a) {
		// TODO Auto-generated method stub
		return aporterep.save(a);
	}

	@Override
	public double calculo_monto_aporte(Aporte a, double aportevoluntario) {
		// TODO Auto-generated method stub
		double montoaporte=0.0;
		if(a.getCcuenta().getNtipocuenta()=="Aportes Obligatorios")
		{
			montoaporte=a.getCcuenta().getCafiliado().getSueldo()*0.10*1.0;
		}else
		{
			montoaporte=aportevoluntario;
		}
		a.setMontoaporte(montoaporte);
		return montoaporte;
	}//EN CASO DE QUE EL APORTE SEA VOLUNTARIO SE DEBE PERMITIR INGRESAR LA CANTIDAD APORTADA 
	//EN EL FORMULARIO DE REGISTRO DE APORTES QUE HARA EL OPERADOR 

	@Override
	public Aporte getporcaporte(int caporte) {
		// TODO Auto-generated method stub
		return aporterep.findOne(caporte);
	}

	@Override
	public Iterable<Aporte> listarporcuenta(int ccuenta) {
		// TODO Auto-generated method stub
		return aporterep.findByIdcuenta(ccuenta);
	}

}
