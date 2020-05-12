package es.soprasteria.formacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "persons")
public class PersonaEntity {

  @Id
  @Column(name = "name")
  private String name;

  @Column(name = "nif")
  private String nif;

  @Column(name = "añoNacimiento")
  private Integer añoNacimiento;

  public Integer getAge() {
    return añoNacimiento;
  }

  public void setAge(Integer age) {
    this.añoNacimiento = añoNacimiento;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }
}
