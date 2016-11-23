package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Afiliado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cafiliado;
	@Size(min=5, max=30)
	private String nnombres;
	@Size(min=5, max=30)
	private String napellidos;
	@Size(min=8)
	private String dni;
	@Size(min=5, max=30)
	private String contrasena;
	
	public Afiliado(){
		super();
	}

	public int getCafiliado() {
		return cafiliado;
	}

	public void setCafiliado(int cafiliado) {
		this.cafiliado = cafiliado;
	}

	public String getNnombres() {
		return nnombres;
	}

	public void setNnombres(String nnombres) {
		this.nnombres = nnombres;
	}

	public String getNapellidos() {
		return napellidos;
	}

	public void setNapellidos(String napellidos) {
		this.napellidos = napellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
}
