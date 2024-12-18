package controller;


import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ClientRepository;

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

    @GetMapping({"idnp"})
    public Client retrieveIdnp(@PathVariable String idnp){
        return clientRepository.retrieveByIdnp(idnp);
    }






}
