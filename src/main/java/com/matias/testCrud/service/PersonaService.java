package com.matias.testCrud.service;

import com.matias.testCrud.entity.Persona;
import com.matias.testCrud.repository.PersonaRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getPersona(Long id) {
        return personaRepository.findById(id);
    }
    
     public int contarPersonaPorPais(String pais) {
         List<Persona> personas = personaRepository.contarPersonaPorPais(pais);
        return personas.size();
    }

    public Persona create(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona update(Persona persona, Long id) {
        Persona personaExistente = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con id " + id));

        personaExistente.setNombre(persona.getNombre());
        personaExistente.setApellido(persona.getApellido());
        personaExistente.setFecha(persona.getFecha());
        personaExistente.setPais(persona.getPais());
        personaExistente.setDireccion(persona.getDireccion());
        personaExistente.setTelefono(persona.getTelefono());
        
        return personaRepository.save(personaExistente);
    }

    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

}
