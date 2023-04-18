
package com.matias.testCrud.repository;

import com.matias.testCrud.entity.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona,Long> {
    
    @Query("SELECT p FROM Persona p WHERE p.pais = :pais")
    public List<Persona> contarPersonaPorPais(@Param("pais")String pais);
}
