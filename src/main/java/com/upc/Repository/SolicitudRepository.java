package com.upc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.Entities.Solicitud;

@Repository
@Transactional
public interface SolicitudRepository extends CrudRepository<Solicitud, Integer> {

	@Query("select s from Solicitud s where s.cafiliado.cafiliado=?1")
	List<Solicitud> findByAfiliado(int cafiliado);
}
