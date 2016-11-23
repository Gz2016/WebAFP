package com.upc.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upc.Entities.Afiliado;

@Repository	
@Transactional
public interface AfiliadoRepository extends CrudRepository<Afiliado, Integer>{

	@Query("select a from Afiliado a where a.dni=?1 and a.contrasena=?2")
	Afiliado findByDniAndContrasena(String dni, String contrasena);
	
	@Query("select a from Afiliado a where a.dni=?1 ")
	Afiliado findByDni(String dni);
	//@Query("select a from Afiliado a where a.ctipofondo.nfondo like ?1")
//	List<Afiliado> findByNFondo(String NFondo); //PROBAR PRIMERO CON ESTE METODO PARA FILTRAR POR NOMBRE DE FONDO 
	//@Query("select a from Afiliado a where a.ctipofondo=?1")
//	List<Afiliado> findByCTipoFondo(int CTipoFondo);  //USAR EN CASO FALLE FINDBYNFONDO
//	@Query("select a from Afiliado a where a.sueldo between ?1 and ?2")
//	List<Afiliado> findBySueldo(double s1, double s2); //AFILIADOS POR SUELDO
//	@Query("select a.ccuenta.cafiliado from Aporte a where a.cintxmora.montointeres between ?1 and ?2")
//	List<Afiliado> findByMontointeres(double m1,double m2);
//	@Query("select a.ccuenta.cafiliado from Aporte a where a.cintxmora.qdias>?1")
//	List<Afiliado> findByDiasdeMoraGreatherThan(int qdias);
//	@Query("select a from Afiliado a where a.dni")
//	List<Afiliado> findByNFondo(String NFondo);
	
}
