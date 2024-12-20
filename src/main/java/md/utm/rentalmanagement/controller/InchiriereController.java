package md.utm.rentalmanagement.controller;

import md.utm.rentalmanagement.entity.Client;
import md.utm.rentalmanagement.entity.Inchiriere;
import md.utm.rentalmanagement.repository.ClientRepository;
import md.utm.rentalmanagement.repository.InchiriereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inchiriere")
public class InchiriereController {
    @Autowired
    private InchiriereRepository inchiriereRepository;

    @GetMapping
    public List<Inchiriere> retrieve(){
        return inchiriereRepository.retrieve();
    }

    @GetMapping("{id}")
    public Inchiriere retrieveById(@PathVariable Long id){
        return inchiriereRepository.retrieveById(id);
    }
    @PostMapping
    public void create(@RequestBody Inchiriere inchiriere) {
        inchiriereRepository.create(inchiriere);
    }

    @PutMapping("{id}")
    public void update( @PathVariable Long id, @RequestBody Inchiriere inchiriere) {
        inchiriereRepository.update(id,inchiriere);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        inchiriereRepository.delete(id);
    }





}
