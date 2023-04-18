package com.matias.testCrud.controller;

import com.matias.testCrud.entity.Persona;
import com.matias.testCrud.service.PersonaService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//crossorigin 
@CrossOrigin(origins="*")
@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;
    

    @GetMapping("persona/traer")
    List<Persona> findAll() {
        return personaService.getPersonas();
    }

    @GetMapping("persona/traer/{id}")
    Optional<Persona> findById(@PathVariable Long id) {
        return personaService.getPersona(id);
    }
    
    // To do - filtrar con PathVariable (String pais)
    @GetMapping("traer/personas/porPaises/{pais}")
    public ResponseEntity<Integer> contarPersonaPorPais(@PathVariable ("pais") String pais) {
        int personasByPais = personaService.contarPersonaPorPais(pais);
        return new ResponseEntity<>(personasByPais, HttpStatus.OK);
    }

    @PostMapping("personas/crear")
    Persona create(@RequestBody Persona persona) {
        return personaService.create(persona);
    }

   /* @PutMapping("personas/editar/{id}")
    Persona update(
            @RequestBody Persona persona,
            @PathVariable("id") Long id
    ) {
        return personaService.update(persona, id);
    }*/
    
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable("id") Long id,
                              @RequestBody Persona persona)
    {
        
        persona.setId(id);
    
    personaService.create(persona);
    return persona;
    }

    @DeleteMapping("personas/borrar/{id}")
    void delete(@PathVariable("id") Long id) {
        personaService.delete(id);
    }
    
    
}
