package es.soprasteria.formacion.rest;

import es.soprasteria.formacion.dto.PersonDto;
import es.soprasteria.formacion.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

  @Autowired
  private PersonService personService;

  @ApiOperation(value="Este método saluda a un usuario")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Llamada ejecutada correctamente"),
      @ApiResponse(code = 500, message = "Error inesperado"),
  })
  @GetMapping("/hello/{name}")
  public String hello(@ApiParam(value="El usuario a saludar") @PathVariable(name="name") String name) {
    return "Hello " + name;
  }

  @ApiOperation(value="Este método busca una persona")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Llamada ejecutada correctamente"),
      @ApiResponse(code = 500, message = "Error inesperado"),
  })
  @GetMapping("/list/{name}")
  public PersonDto findPerson(@ApiParam(value="Nombre de la persona") @PathVariable(name = "name") String name) {
    return personService.getByName(name);
  }

  @ApiOperation(value="Este método lista todas las personas")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Llamada ejecutada correctamente"),
      @ApiResponse(code = 500, message = "Error inesperado"),
  })
  @GetMapping("/list")
  public List<PersonDto> listPerson() {
    return personService.getAllPersons();
  }

  @ApiOperation(value="Este método crea una persona")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Llamada ejecutada correctamente"),
      @ApiResponse(code = 500, message = "Error inesperado"),
  })
  @PostMapping("/person")
  public PersonDto createPerson(@RequestBody PersonDto newPerson) {
    return personService.createPerson(newPerson);
  }

  @ApiOperation(value="Este método elimina una persona")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Llamada ejecutada correctamente"),
      @ApiResponse(code = 500, message = "Error inesperado"),
  })
  @DeleteMapping("/person/delete/{name}")
  public List<PersonDto> deletePerson(@PathVariable(name = "name") String name){
    return personService.deleteByName(name);
  }

}
