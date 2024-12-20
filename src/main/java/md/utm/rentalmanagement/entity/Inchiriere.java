package md.utm.rentalmanagement.entity;

import jakarta.validation.constraints.NotBlank;

public class Inchiriere {
  private Long id;
  @NotBlank(message="id client is mandatory" )
  private Long id_client;
  @NotBlank(message= "id masina is mandatory")
  private Long id_masina;
  @NotBlank(message="data inchiriere is mandatory")
  private String data_inchiriere;
  @NotBlank(message="data returnare is mandatory")
  private String data_returnare;

  public Inchiriere(Long id, Long id_client, Long id_masina, String data_inchiriere, String data_returnare) {
      this.id= id;
      this.id_client = id_client;
      this.id_masina = id_masina;
      this.data_inchiriere = data_inchiriere;
      this.data_returnare = data_returnare;

  }

    public String getData_returnare() {
        return data_returnare;
    }

    public void setData_returnare(String data_returnare) {
        this.data_returnare = data_returnare;
    }

    public String getData_inchiriere() {
        return data_inchiriere;
    }

    public void setData_inchiriere(String data_inchiriere) {
        this.data_inchiriere = data_inchiriere;
    }

    public Long getId_masina() {
        return id_masina;
    }

    public void setId_masina(Long id_masina) {
        this.id_masina = id_masina;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Inchiriere{" +
                "id=" + id +
                ", id_client=" + id_client +
                ", id_masina=" + id_masina +
                ", data_inchiriere='" + data_inchiriere + '\'' +
                ", data_returnare='" + data_returnare + '\'' +
                '}';
    }
}
