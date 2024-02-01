/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package employee.com.employee_database.entities.repositories;

import employee.com.employee_database.entities.ContaTipo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jacinto
 */
public interface ContaTipoRepository extends JpaRepository<ContaTipo, Integer> {

    @Query(value = "SELECT * FROM conta_tipo WHERE designacao = ?1", nativeQuery = true)
    public ContaTipo existsByDesignacao(String designacao);
    
    @Query(value = "SELECT * FROM conta_tipo WHERE pk_conta_tipo = ?1", nativeQuery = true)
    public ContaTipo existsByPkContaTipo(int pk_conta_tipo);

    @Query(value = "SELECT * FROM conta_tipo ORDER BY designacao ", nativeQuery = true)
    public List<ContaTipo> contaTipoListar();

}
