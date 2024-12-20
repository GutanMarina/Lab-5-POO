package md.utm.rentalmanagement.controller;

import md.utm.rentalmanagement.entity.Client;
import md.utm.rentalmanagement.entity.Masina;
import md.utm.rentalmanagement.repository.ClientRepository;
import md.utm.rentalmanagement.repository.MasinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("masina")

public class MasinaController {

    @Autowired
    private MasinaRepository masinaRepository;

    @GetMapping
    public List<Masina> retrieve(){
        return masinaRepository.retrieve();
    }
    @GetMapping("marca")
    public List<Masina> retrieveByBrand(@RequestParam("marca") String brand) {
        return masinaRepository.retrieveByBrand(brand);
    }

    @GetMapping("greaterThan")
    public List<Masina> retrieveMasinaGreaterThan(@RequestParam("anul_producerii") int year_production) {
        return masinaRepository.retrieveMasinaGreaterThan(year_production);
    }

    @PostMapping
    public void create(@RequestBody Masina masina) {
        masinaRepository.create(masina);
    }

    @PutMapping("{id}")
    public void update( @PathVariable Long id, @RequestBody Masina masina) {
        masinaRepository.update(id,masina);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        masinaRepository.delete(id);
    }

}
