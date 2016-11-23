package com.upc.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.Entities.Solicitud;
import com.upc.Repository.SolicitudRepository;

@Service
public class SolicitudServiceImpl implements SolicitudService {

	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@Override
	public Solicitud saveSolicitud(Solicitud s) {
		// TODO Auto-generated method stub
		return solicitudRepository.save(s);
	}

	@Override
	public void deleteSolicitud(int csolicitud) {
		// TODO Auto-generated method stub
		solicitudRepository.delete(csolicitud);
	}

	@Override
	public Iterable<Solicitud> listSolicitudesAfiliado(int cafiliado) {
		// TODO Auto-generated method stub
		return solicitudRepository.findByAfiliado(cafiliado);
	}

	@Override
	public double calcularRentabilidad(Solicitud s) {//FALTA CALCULAR RENTABILIDAD SEGÚN TIPO DE FONDO
		// TODO Auto-generated method stub
		double rentabilidad=0;
		if(s.getTipofondo().equals("Fondo 1")){
			rentabilidad=3.5;
		}else if(s.getTipofondo().equals("Fondo 2")){
			rentabilidad=5.5;
		}else{
			rentabilidad=8;
		}
		
		return rentabilidad;
	}

	@Override
	public double calcularComisionPorFlujo(Solicitud s) {
		double cpf=0;
		if(s.getTipoafp().equals("Integra")){
			cpf=1.55;
		}else if(s.getTipoafp().equals("Prima")){
			cpf=1.60;
		}else if(s.getTipoafp().equals("Profuturo")){
			cpf=1.69;
		}else{
			cpf=1.47;
		}
		
		return cpf;
	}

	@Override
	public double calcularComisionPorSaldo(Solicitud s) {
		double cps=0;
		if(s.getTipoafp().equals("Integra")){
			cps=1.20;
		}else if(s.getTipoafp().equals("Prima")){
			cps=1.25;
		}else if(s.getTipoafp().equals("Profuturo")){
			cps=1.20;
		}else{
			cps=1.25;
		}
		return cps;
	}

	@Override
	public Solicitud findSolicitudbyid(int id) {
		// TODO Auto-generated method stub
		return solicitudRepository.findOne(id);
	}

	@Override
	public int calcularmeses(Solicitud s) {
		// TODO Auto-generated method stub
		int meses = 0;
		/*int edad = s.getEdad();
		int diferencia= 65-edad;
		meses=diferencia*12;
		return meses;
		*/
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date fechaInicio = dateFormat.parse(s.getFechanacimiento());
			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(fechaInicio);
			Calendar endCalendar = Calendar.getInstance();
			int edadActual = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			meses= (65-edadActual)*12;
			return meses;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meses;
	}

	

}
