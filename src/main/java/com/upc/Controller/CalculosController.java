package com.upc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.Entities.Calculo;
import com.upc.Entities.Solicitud;
import com.upc.Service.AfiliadoService;
import com.upc.Service.CalculosService;
import com.upc.Service.SolicitudService;

@Controller
public class CalculosController {
	
	@Autowired
	private CalculosService calculosserv;
	
	@Autowired
	private SolicitudService solicitudserv;
	
	@Autowired
	private AfiliadoService afiliadoserv;
	
	private double rentanual,rentmensual,fondo,sueldo,saldo,pension,cpf,cps,comisionflujo,comisionsaldo,totalcpf,totalcps,porc;
	private int cantmeses;
	
	@RequestMapping(value="/calculos")
	public String calculos()
	{
		return "calculos";
	}
	
	@RequestMapping(value="/calculoflujo{id}")
	public String flujo(@PathVariable int id, Model model)
	{
		//Afiliado a = afiliadoserv.findAfiliado(id);
		int codigo=id;
		model.addAttribute("afiliado", codigo);
		model.addAttribute("solicitud", new Solicitud());
		return "calculoflujo";
	}
	
	@RequestMapping(value="/calculoflujoresultado", method=RequestMethod.POST)
	public String flujoresultado(@Valid Solicitud s, Model m,HttpServletRequest request)
	{
		//Afiliado a=s.getCafiliado();
		//afiliadoserv.crear(a);
		//s.setCafiliado(afiliadoserv.findAfiliado(s.getCafiliado().getCafiliado()));
		int cod=Integer.parseInt(request.getParameter("cod"));
		s.setCafiliado(afiliadoserv.findAfiliado(cod));
		solicitudserv.saveSolicitud(s);
		
		Calculo calculonuevo= new Calculo();
		List<Calculo> calculos = new ArrayList<>();
		
		cantmeses=solicitudserv.calcularmeses(s);
		cpf=solicitudserv.calcularComisionPorFlujo(s)/100;
		sueldo=s.getSueldoactual();
		fondo=s.getFondoactual();
		rentanual=solicitudserv.calcularRentabilidad(s)/100;
		rentmensual=calculosserv.calcular_rentabilidad_mensual(rentanual);
		totalcpf=0;
		comisionflujo=calculosserv.calcular_comision_flujo(cpf, sueldo);
		//AÑADIR A TABLA FONDO CON MES i=0, FONDO=FONDO INICIAL, CPF=0
		calculonuevo.setMes(0);
		calculonuevo.setFondo(calculosserv.redondear(fondo));
		calculonuevo.setCpf(0);
		calculos.add(calculonuevo);
		for(int i=0;i<cantmeses;i++)
		{
			calculonuevo= new Calculo();
			fondo=calculosserv.calcular_fondo_comision_flujo(rentmensual, fondo, sueldo);
			//AÑADIR A TABLA FONDO CON MES i=actual+1, FONDO=FONDO ACTUAL, CPF=comisionflujo
			totalcpf+=comisionflujo;
			calculonuevo.setMes(i+1);
			calculonuevo.setFondo(calculosserv.redondear(fondo));
			calculonuevo.setCpf(calculosserv.redondear(comisionflujo));
			calculos.add(calculonuevo);
		}
		m.addAttribute("mensaje1","* La COMISION TOTAL COBRADA es de "+calculosserv.redondear(totalcpf)+" nuevos soles.");
		m.addAttribute("mensaje2","* El FONDO FINAL es de "+calculosserv.redondear(fondo)+" nuevos soles.");
		m.addAttribute("tablaflujo", calculos);
		m.addAttribute("afiliado", cod);
		return "calculoflujo";
	}
	
	@RequestMapping(value="/calculosaldo{id}")
	public String saldo(@PathVariable int id, Model model)
	{
		int codigo=id;
		model.addAttribute("afiliado", codigo);
		model.addAttribute("solicitud", new Solicitud());
		return "calculosaldo";
	}
	
	@RequestMapping(value="/calculosaldoresultado", method=RequestMethod.POST )
	public String saldoresultado(@Valid Solicitud s,Model m,HttpServletRequest request)
	{
		int cod=Integer.parseInt(request.getParameter("cod"));
		s.setCafiliado(afiliadoserv.findAfiliado(cod));
		solicitudserv.saveSolicitud(s);
		
		Calculo calculonuevo= new Calculo();
		List<Calculo> calculos = new ArrayList<>();
		
		fondo=s.getFondoactual();
		sueldo=s.getSueldoactual();
		cps=solicitudserv.calcularComisionPorSaldo(s)/100;
		cantmeses=solicitudserv.calcularmeses(s);
		rentanual=solicitudserv.calcularRentabilidad(s)/100;
		rentmensual=calculosserv.calcular_rentabilidad_mensual(rentanual);
		totalcps=0;
		saldo=0;
		comisionsaldo=0;
		calculonuevo.setMes(0);
		calculonuevo.setFondo(calculosserv.redondear(fondo));
		calculonuevo.setSaldo(0);
		calculonuevo.setCps(0);
		calculos.add(calculonuevo);
		//AÑADIR A TABLA FONDO CON MES i=0, FONDO=FONDO INICIAL, SALDO=0, CPS=0
		for(int i=0;i<cantmeses;i++)
		{
			calculonuevo= new Calculo();
			saldo=calculosserv.calcular_fondo_o_saldo_comision_saldo(rentmensual, saldo, sueldo, comisionsaldo);
			comisionsaldo=saldo*cps/12;
			fondo=calculosserv.calcular_fondo_o_saldo_comision_saldo(rentmensual, fondo, sueldo, comisionsaldo);
			totalcps+=comisionsaldo;
			//AÑADIR A TABLA FONDO CON MES i=actual+1, FONDO=FONDO ACTUAL, SALDO=SALDO ACTUAL, CPS=comisionsaldo
			calculonuevo.setMes(i+1);
			calculonuevo.setFondo(calculosserv.redondear(fondo));
			calculonuevo.setSaldo(calculosserv.redondear(saldo));
			calculonuevo.setCps(calculosserv.redondear(comisionsaldo));
			calculos.add(calculonuevo);
		}
		m.addAttribute("mensaje1","* La COMISION TOTAL COBRADA es de "+calculosserv.redondear(totalcps)+" nuevos soles.");
		m.addAttribute("mensaje2","* El SALDO FINAL es de "+calculosserv.redondear(saldo)+" nuevos soles.");
		m.addAttribute("mensaje3","* El FONDO FINAL es de "+calculosserv.redondear(fondo)+" nuevos soles.");
		m.addAttribute("tablasaldo", calculos);
		m.addAttribute("afiliado", cod);
		return "calculosaldo";
	}
	
	@RequestMapping(value="/calculomixto{id}")
	public String mixto(@PathVariable int id, Model model)
	{   
		int codigo=id;
		model.addAttribute("afiliado", codigo);
		model.addAttribute("solicitud", new Solicitud());
		return "calculomixto";
	}
	
	@RequestMapping(value="/calculomixtoresultado", method=RequestMethod.POST)
	public String mixtoresultado(@Valid Solicitud s,Model m,HttpServletRequest request)
	{
		int cod=Integer.parseInt(request.getParameter("cod"));
		s.setCafiliado(afiliadoserv.findAfiliado(cod));
		solicitudserv.saveSolicitud(s);
		
		Calculo calculonuevo= new Calculo();
		List<Calculo> calculos = new ArrayList<>();
		
		rentanual=solicitudserv.calcularRentabilidad(s)/100;
		//rentanual=Double.parseDouble(request.getParameter("rentanual"))/100;
		rentmensual=calculosserv.calcular_rentabilidad_mensual(rentanual);
		fondo=s.getFondoactual();
		//fondo=Double.parseDouble(request.getParameter("fondo"));
		sueldo=s.getSueldoactual();
		//sueldo=Double.parseDouble(request.getParameter("sueldo"));
		//cpf=Double.parseDouble(request.getParameter("cpf"))/100;
		//cps=Double.parseDouble(request.getParameter("cps"))/100;
		cpf=solicitudserv.calcularComisionPorFlujo(s)/100;
		cps=solicitudserv.calcularComisionPorSaldo(s)/100;
		cantmeses=solicitudserv.calcularmeses(s);
		//cantmeses=Integer.parseInt(request.getParameter("cantmeses"));
		totalcpf=0;
		totalcps=0;
		saldo=0;
		comisionsaldo=0;
		porc=calculosserv.calcular_porcentaje_flujo_comision_mixto(0);
		calculonuevo.setMes(0);
		calculonuevo.setFondo(calculosserv.redondear(fondo));
		calculonuevo.setSaldo(0);
		calculonuevo.setPorcflujo(0);
		calculonuevo.setPorcsaldo(0);
		calculonuevo.setCpf(0);
		calculonuevo.setCps(0);
		calculos.add(calculonuevo);
		for(int i=0;i<cantmeses;i++)
		{
			porc=calculosserv.calcular_porcentaje_flujo_comision_mixto(i+1);
			calculonuevo= new Calculo();
			saldo=calculosserv.calcular_fondo_o_saldo_comision_saldo(rentmensual, saldo, sueldo, comisionsaldo);
			comisionflujo=calculosserv.calcular_comision_flujo(cpf*porc, sueldo);
			comisionsaldo=saldo*(cps*(1-porc))/12;
			fondo=calculosserv.calcular_fondo_o_saldo_comision_saldo(rentmensual, fondo, sueldo, comisionsaldo);
			totalcpf+=comisionflujo;
			totalcps+=comisionsaldo;
			calculonuevo.setMes(i+1);
			calculonuevo.setFondo(calculosserv.redondear(fondo));
			calculonuevo.setSaldo(calculosserv.redondear(saldo));
			calculonuevo.setPorcflujo(calculosserv.redondear(porc*100));
			calculonuevo.setPorcsaldo(calculosserv.redondear((1-porc)*100));
			calculonuevo.setCpf(calculosserv.redondear(comisionflujo));
			calculonuevo.setCps(calculosserv.redondear(comisionsaldo));
			calculos.add(calculonuevo);
		}
		m.addAttribute("mensaje1","* La COMISION TOTAL POR FLUJO es de "+calculosserv.redondear(totalcpf)+" nuevos soles.");
		//m.addAttribute("mensaje2","* La COMISION TOTAL POR SALDO es de "+calculosserv.redondear(totalcps)+" nuevos soles.");
		m.addAttribute("mensaje2","* asd: "+s.getTipoafp()+" "+cpf+" "+cps);
		m.addAttribute("mensaje3","* La COMISION TOTAL COBRADA (F+S) es de "+calculosserv.redondear(totalcpf+totalcps)+" nuevos soles.");
		m.addAttribute("mensaje4","* El SALDO FINAL es de "+calculosserv.redondear(saldo)+" nuevos soles.");
		m.addAttribute("mensaje5","* El FONDO FINAL es de "+calculosserv.redondear(fondo)+" nuevos soles.");
		m.addAttribute("tablamixto", calculos);
		m.addAttribute("afiliado", cod);
		return "calculomixto";
	}
	
	@RequestMapping(value="/calculopension{id}")
	public String pension(@PathVariable int id, Model model)
	{
		int codigo=id;
		model.addAttribute("afiliado", codigo);
		model.addAttribute("solicitud", new Solicitud());
		return "calculopension";
	}
	
	@RequestMapping(value="/calculopensionresultado", method=RequestMethod.POST )
	public String pensionresultado(@Valid Solicitud s,Model m,HttpServletRequest request)
	{	
		solicitudserv.saveSolicitud(s);
		
		fondo=s.getFondoactual();
		cantmeses=solicitudserv.calcularmeses(s);
		rentanual=solicitudserv.calcularRentabilidad(s)/100;
		rentmensual=calculosserv.calcular_rentabilidad_mensual(rentanual);
		/*
		rentanual=Double.parseDouble(request.getParameter("rentanual"))/100;
		rentmensual=calculosserv.calcular_rentabilidad_mensual(rentanual);
		fondo=Double.parseDouble(request.getParameter("fondo"));
		cantmeses=Integer.parseInt(request.getParameter("cantmeses"));
		*/
		pension=calculosserv.calcular_pension(rentmensual, fondo, cantmeses);
		
		m.addAttribute("mensaje","* La pension a recibir es de "+calculosserv.redondear(pension)+" nuevos soles.");
		return "calculopension";
	}
	
	@RequestMapping(value="/missolicitudes", method=RequestMethod.POST)
	public String missolicitudes(@RequestParam int id, Model m){
		m.addAttribute("solicitudes", solicitudserv.findSolicitudbyid(id));
		return "solicitudes";
	}
}
