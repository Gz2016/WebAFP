package com.upc.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.Entities.Afiliado;
import com.upc.Service.AfiliadoService;

@Controller
public class AfiliadoController {
@Autowired
private AfiliadoService afiliadoserv;

@RequestMapping(value="/nuevoafiliado")
public String nuevoafiliado(Model m)
{
	m.addAttribute("afiliado",new Afiliado());
	return "nuevoafiliado"; //VISTA <input placeholder="ID de la empresa" type="text" th:field="*{crep_empresa.crep_empresa}"/>
}

@RequestMapping(value="/login")
public String login()
{
	return "login";
}

@RequestMapping(value="/inicioafiliado", method=RequestMethod.POST)
public String login(@RequestParam String dni, @RequestParam String contrasena, Model model)
{
	Afiliado a= afiliadoserv.autenticar(dni, contrasena);
	if(a==null){
	   model.addAttribute("mensaje", "El usuario y/o contraseña que ingresó no existen o no coinciden");
	   return "login";
	}else{
		model.addAttribute("afiliado", a);
		return "inicioafiliado";
	}
}

@RequestMapping(value="/crearafiliado", method=RequestMethod.POST)
public String crearafiliado(@Valid Afiliado a,BindingResult result, Model m)
{
	try 
	{
		if(result.hasErrors())
		{
			if(a.getNnombres()=="" || a.getNapellidos() == "" || a.getDni() == "" || a.getContrasena() == "")
			{
				m.addAttribute("mensaje","*Debes llenar todos los campos.");
				return "nuevoafiliado"; 
			}
			else
			{
				Afiliado af_buscado = afiliadoserv.findByDni(a.getDni());
				
				if(a.getNnombres().length()<5 || a.getNnombres().length()>30)
				{
					m.addAttribute("mensaje","*Los nombres deben tener entre 5 y 30 caracteres");
					return "nuevoafiliado";
				}
				
				if(a.getNapellidos().length()<5 || a.getNapellidos().length()>30)
				{
					m.addAttribute("mensaje","*Los apellidos deben tener entre 5 y 30 caracteres");
					return "nuevoafiliado";
				}
				
				if(af_buscado != null)
				{
					m.addAttribute("mensaje","*Ya existe un afiliado con este DNI");
					return "nuevoafiliado";
				}
				
				if(a.getContrasena().length()<5 || a.getContrasena().length()>30)
				{
					m.addAttribute("mensaje","*La contraseña debe tener entre 5 y 30 caracteres");
					return "nuevoafiliado";
				}
			}
		}
		
		afiliadoserv.crear(a);
		return "redirect:/login";//REGRESA A LA VISTA
		
	} catch (Exception e) {
		m.addAttribute("mensaje","*Ha ocurrido un error. Por favor, contacta con soporte técnico.");
		return "nuevoafiliado"; 
	}
}


}
