package es.soprasteria.formacion.dto;

public class PersonDto {

  private String name;
  private String nif;
  private Integer age;

  public PersonDto(String name, String nif, Integer age) {
    this.name = name;
    this.nif = nif;
    this.age = age;
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
