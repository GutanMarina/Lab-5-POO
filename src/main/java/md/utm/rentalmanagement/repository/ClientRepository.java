package md.utm.rentalmanagement.repository;

import md.utm.rentalmanagement.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class ClientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> retrieve() {
        return jdbcTemplate.query("SELECT * FROM client",
                (row, index) -> {
            Long id = row.getLong("id_client");
            String idnp = row.getString("idnp");
            String nume = row.getString("nume");
            String telefon = row.getString("telefon");

            return new Client(id,idnp, nume, telefon);
        });
    }

    public Client retrieveByIdnp(String idnp) {
        return jdbcTemplate.queryForObject("select * from client where idnp=?",
                (row, index) -> {
                    Long id = row.getLong("id_client");
                    String idnp_intern = row.getString("idnp");
                    String nume = row.getString("nume");
                    String telefon = row.getString("telefon");
                    return new Client(id,idnp_intern, nume, telefon);
                },
                idnp);
    }


    public List<Client> retrieveByPhone(String phone) {
        return jdbcTemplate.query("SELECT * FROM client where telefon=?",
                (row, index) -> {
                    Long id = row.getLong("id_client");
                    String idnp_intern = row.getString("idnp");
                    String nume = row.getString("nume");
                    String telefon = row.getString("telefon");

                    return new Client(id, idnp_intern, nume, telefon);
                }, phone);
    }

        public void create(Client client) {
        jdbcTemplate.update("insert into client (idnp, nume, telefon) values(?,?,?)",
                client.getIdnp(), client.getNume(), client.getTelefon());

    }

    public void update(String idnp, @RequestBody Client client) {
        jdbcTemplate.update("update client set nume=?, telefon=?\n" +
                "where idnp=?", client.getNume(), client.getTelefon(), idnp);
    }

    public void delete(String idnp) {
        jdbcTemplate.update("delete from client where idnp=?", idnp);
    }
  public boolean existsByIdnp(String idnp){
        Integer count=this.jdbcTemplate.queryForObject(
                "select count(*) from client where idnp=?",new Object[]{idnp}, Integer.class);
      return count != null && count > 0;
  }
    public boolean existsByPhone(String phone) {
        Integer count = this.jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM client WHERE telefon = ?",new Object[]{phone}, Integer.class);
        return count != null && count > 0;
    }
}
