/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package employee.com.employee_database.entities.repositories;

import employee.com.employee_database.entities.Conta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author jacinto
 */
public interface ContaRepository extends JpaRepository<Conta, Integer> {

    @Query(value = "SELECT * FROM public.conta ORDER BY username", nativeQuery = true)
    public List<Conta> contaListar();

    @Query(value = "SELECT * FROM public.conta WHERE username = ?1", nativeQuery = true)
    public Conta pesquisarContaByUsername(String username);

    @Query(value = "SELECT * FROM public.conta WHERE pk_conta = ?1", nativeQuery = true)
    public Conta pesquisarContaByPkConta(int pk_conta);

    @Query(value = "SELECT * FROM public.conta WHERE username = ?1", nativeQuery = true)
    public UserDetails autenticarContaByUsername(String username);

}
