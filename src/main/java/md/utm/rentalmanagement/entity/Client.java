package md.utm.rentalmanagement.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Client {

    private Long id;
    @Size(min = 13, max = 13, message = "idnp should be 13 characters long.")
    private String idnp;
    @NotBlank(message = "name is mandatory")
    private String nume;
    @NotBlank(message = "phone number is mandatory")
    @Pattern(
            regexp = "^[1-9][0-9]{7}$",
            message = "Phone number should be 8 characters long and not include 0 at the beginning"
    )
    private String telefon;


    public Client(Long id, String idnp, String nume, String telefon) {
        this.id=id;
        this.idnp = idnp;
        this.nume = nume;
        this.telefon = telefon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdnp() {
        return idnp;
    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", idnp='" + idnp + '\'' +
                ", nume='" + nume + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
