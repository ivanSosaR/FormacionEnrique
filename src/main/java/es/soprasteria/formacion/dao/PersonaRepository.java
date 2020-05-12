package es.soprasteria.formacion.dao;

import es.soprasteria.formacion.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity,String>{

}
