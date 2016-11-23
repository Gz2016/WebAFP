package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Solicitud {
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int csolicitud;
	
	@Size(min=4,max=45)
	private String tipofondo;
	@Size(min=4,max=45)
	private String tipoafp;
	@Min(0)
	@Digits(integer=10,fraction=2)
	private double fondoactual;
	@Size(min=10,max=10)
	private String fechanacimiento;
	@Min(0)
	@Digits(integer=10,fraction=2)
	private double sueldoactual;
	@ManyToOne//(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cafiliado")
	private Afiliado cafiliado;
	
	public Solicitud(){
		super();
	}

	public int getCsolicitud() {
		return csolicitud;
	}

	public void setCsolicitud(int csolicitud) {
		this.csolicitud = csolicitud;
	}

	public String getTipofondo() {
		return tipofondo;
	}

	public void setTipofondo(String tipofondo) {
		this.tipofondo = tipofondo;
	}

	public String getTipoafp() {
		return tipoafp;
	}

	public void setTipoafp(String tipoafp) {
		this.tipoafp = tipoafp;
	}

	public double getFondoactual() {
		return fondoactual;
	}

	public void setFondoactual(double fondoactual) {
		this.fondoactual = fondoactual;
	}

	public double getSueldoactual() {
		return sueldoactual;
	}

	public void setSueldoactual(double sueldoactual) {
		this.sueldoactual = sueldoactual;
	}

	public Afiliado getCafiliado() {
		return cafiliado;
	}

	public void setCafiliado(Afiliado cafiliado) {
		this.cafiliado = cafiliado;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	
	
	
}
