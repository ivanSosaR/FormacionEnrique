package es.soprasteria.formacion.service;

import es.soprasteria.formacion.dao.PersonaRepository;
import es.soprasteria.formacion.dto.PersonDto;
import es.soprasteria.formacion.entity.PersonaEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonaRepository personaRepository;

  @Override
  public PersonDto getByName(String name) {
    PersonaEntity entity = personaRepository.findById(name).get();
    Integer edad = 2020 - entity.getAge();
    PersonDto dto = new PersonDto(entity.getName(), entity.getNif(), calcularEdad(entity.getAge()));
    return dto;
  }

  @Override
  public List<PersonDto> getAllPersons() {
    List<PersonaEntity> entities = personaRepository.findAll();
    List<PersonDto> personDtos = entities.stream()
        .map(personaEntity -> new PersonDto(personaEntity.getName(), personaEntity.getNif(), calcularEdad(personaEntity.getAge())))
        .collect(Collectors.toList());
    return personDtos;
  }

  @Override
  public PersonDto createPerson(PersonDto persona) {
    PersonaEntity personaEntity = new PersonaEntity();
    personaEntity.setAge(persona.getAge());
    personaEntity.setName(persona.getName());

    PersonaEntity persistedEntity = personaRepository.save(personaEntity);
    PersonDto personDto = new PersonDto(persistedEntity.getName(), persistedEntity.getNif(), calcularEdad(persistedEntity.getAge()));
    return personDto;
  }

  @Override
  public List<PersonDto> deleteByName(String name) {
    personaRepository.delete(personaRepository.findById(name).get());
    List<PersonaEntity> entities = personaRepository.findAll();
    List<PersonDto> personDtos = entities.stream()
        .map(personaEntity -> new PersonDto(personaEntity.getName(), personaEntity.getNif(), calcularEdad(personaEntity.getAge())))
        .collect(Collectors.toList());
    return personDtos;
  }

  private Integer calcularEdad(Integer año) {
    return 2020 - año;
  }

}
