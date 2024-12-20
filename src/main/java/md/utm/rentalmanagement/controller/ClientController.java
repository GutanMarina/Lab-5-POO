package md.utm.rentalmanagement.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import md.utm.rentalmanagement.entity.Client;
import md.utm.rentalmanagement.exception.type.AlreadyExistException;
import md.utm.rentalmanagement.exception.type.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import md.utm.rentalmanagement.repository.ClientRepository;

import java.util.List;

@RestController
@RequestMapping("client")

public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> retrieve(){
        return clientRepository.retrieve();
    }
    @GetMapping("phone")
    public List<Client> retrieveByPhone(@RequestParam("telefon")
            @Pattern(
                    regexp = "^[1-9][0-9]{7}$",
                    message = "Phone number must be exactly 8 digits and cannot start with 0"
            ) String phone)  {
        if(!clientRepository.existsByPhone(phone)) {
            throw new NotFoundException();
        }
        return clientRepository.retrieveByPhone(phone);
    }

    @GetMapping("{idnp}")
    public Client retrieveIdnp( @PathVariable String idnp){
        if(!clientRepository.existsByIdnp(idnp))
            throw new NotFoundException();
        return clientRepository.retrieveByIdnp(idnp);
    }
    @PostMapping
    public void create( @Valid @RequestBody Client client) {
        if(clientRepository.existsByIdnp(client.getIdnp()))
            throw new AlreadyExistException();
        clientRepository.create(client);
    }

    @PutMapping("{idnp}")
    public void update( @Valid @PathVariable String idnp, @RequestBody Client client) {
        clientRepository.update(idnp,client);
    }
    @DeleteMapping("{idnp}")
    public void delete(@PathVariable String idnp) {
        clientRepository.delete(idnp);
    }
}
