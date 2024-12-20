package md.utm.rentalmanagement.entity;

import jakarta.validation.constraints.NotBlank;

public class Masina {
    private Long id;
    @NotBlank( message="marca is mandatory")
    private String marca;
    @NotBlank(message="model is mandatory")
    private String model;
    @NotBlank(message="anul producerii is mandatory")
    private Long anul_producerii;

    public Masina(Long id, String marca, String model, Long anul_producerii) {
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.anul_producerii = anul_producerii;
    }

    public Long getAnul_producerii() {
        return anul_producerii;
    }

    public void setAnul_producerii(Long anul_producerii) {
        this.anul_producerii = anul_producerii;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", anul_producerii='" + anul_producerii + '\'' +
                '}';
    }
}
