package md.utm.rentalmanagement.repository;

import md.utm.rentalmanagement.entity.Inchiriere;
import md.utm.rentalmanagement.entity.Masina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class InchiriereRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Inchiriere> retrieve() {
        return jdbcTemplate.query("SELECT * FROM inchiriere",
                (row, index) -> {
                    Long id = row.getLong("id");
                    Long id_client = row.getLong("id_client");
                    Long id_masina = row.getLong("id_masina");
                    String data_inchiriere = row.getString("data_inchiriere");
                    String data_returnare=row.getString("data_returnare");
                    return new Inchiriere(id,id_client, id_masina, data_inchiriere, data_returnare);
                });
    }

    public Inchiriere retrieveById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM inchiriere where id = ?",
                (row, index) -> {
                    Long id_inchiriere = row.getLong("id");
                    Long id_client = row.getLong("id_client");
                    Long id_masina = row.getLong("id_masina");
                    String data_inchiriere = row.getString("data_inchiriere");
                    String data_returnare=row.getString("data_returnare");

                    return new Inchiriere(id_inchiriere, id_client, id_masina, data_inchiriere, data_returnare);
                },
                id);
    }

    public List<Inchiriere> retrieveInchiriereDataReturn(int return_data) {
        return jdbcTemplate.query("SELECT * FROM inchiriere where data_returnare = ?",
                (row, index) -> {
                    Long id = row.getLong("id");
                    Long id_client = row.getLong("id_client");
                    Long id_masina = row.getLong("id_masina");
                    String data_inchiriere = row.getString("data_inchiriere");
                    String data_returnare= row.getString("data_returnare");

                    return new Inchiriere(id, id_client, id_masina, data_inchiriere, data_returnare);
                }, return_data);
    }


    public void create(Inchiriere inchiriere) {
        jdbcTemplate.update("insert into inchiriere (id_client, id_masina, data_inchiriere, data_returnare) values(?,?,?,?)",
                inchiriere.getId_client(), inchiriere.getId_masina(), inchiriere.getData_inchiriere(), inchiriere.getData_returnare());

    }

    public void update(Long id, @RequestBody Inchiriere inchiriere) {
        jdbcTemplate.update("update inchiriere set id_client= ?, id_masina= ?, data_inchiriere=? ,data_returnare = ?\n"+
                "where id  = ?", inchiriere.getId_client(), inchiriere.getId_masina(), inchiriere.getData_inchiriere(),inchiriere.getData_returnare(), id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from inchiriere where id=?", id);
    }
}
