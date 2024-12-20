package md.utm.rentalmanagement.repository;

import md.utm.rentalmanagement.entity.Masina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class MasinaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Masina> retrieve() {
        return jdbcTemplate.query("SELECT * FROM masina",
                (row, index) -> {
                    Long id = row.getLong("id_masina");
                    String marca = row.getString("marca");
                    String model = row.getString("model");
                   Long anul_producerii = row.getLong("anul_producerii");

                    return new Masina(id,marca, model,anul_producerii);
                });
    }

    public List<Masina> retrieveByBrand(String brand) {
        return jdbcTemplate.query("SELECT * FROM masina WHERE marca=?",
                (row, index) -> {
                    Long id = row.getLong("id_masina");
                    String marca = row.getString("marca");
                    String model= row.getString("model");
                    Long anul_producerii = row.getLong("anul_producerii");
                    return new Masina (id,marca, model, anul_producerii);
                },
                brand);
    }

    public List<Masina> retrieveMasinaGreaterThan(int year_production) {
        return jdbcTemplate.query("SELECT * FROM masina where anul_producerii > ?",
                (row, index) -> {
                    Long id = row.getLong("id_masina");
                    String marca= row.getString("marca");
                    String model = row.getString("model");
                    Long anul_producerii = row.getLong("anul_producerii");

                    return new Masina(id, marca, model, anul_producerii);
                }, year_production);
    }


    public void create(Masina masina) {
        jdbcTemplate.update("insert into masina (marca, model, anul_producerii) values(?,?,?)",
                masina.getMarca(), masina.getModel(), masina.getAnul_producerii());

    }

    public void update(Long id, @RequestBody Masina masina) {
        jdbcTemplate.update("update masina set marca = ?, model= ? ,anul_producerii = ?\n"+
                "where id_masina  = ?", masina.getMarca(), masina.getModel(), masina.getAnul_producerii(), id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from masina where id_masina=?", id);
    }

}
