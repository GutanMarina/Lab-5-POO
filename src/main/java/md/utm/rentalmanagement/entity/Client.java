package entity;

public class Client {

    private String idnp;
    private String nume;
    private String telefon;


    public Client(String idnp, String nume, String telefon) {
        this.idnp = idnp;
        this.nume = nume;
        this.telefon = telefon;
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
}
