package repository;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public class ClientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Client> retrieve(){

        return jdbcTemplate.query("select * from client", (row,index) -> {
            String idnp=row.getString("idnp");
            String nume=row.getString("nume");
            String telefon=row.getString("telefon");

            return new Client (idnp, nume, telefon);
        });

    }
public Client retrieveByIdnp(String idnp) {
    return jdbcTemplate.queryForObject("select * from client where idnp=?",
            (row, index) -> {
                String id = row.getString("idnp");
                String nume = row.getString("nume");
                String telefon = row.getString("telefon");
                return new Client(idnp, nume, telefon);
            },
            idnp);
}





}
