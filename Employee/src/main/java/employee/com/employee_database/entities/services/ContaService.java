/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package employee.com.employee_database.entities.services;

import employee.com.employee_database.entities.Conta;
import employee.com.employee_database.entities.dtos.AutenticacaoDto;
import employee.com.employee_database.entities.dtos.ContaDto;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public interface ContaService {
    List<Conta> contaListar();
    Conta contaSalvar(ContaDto contaDto);
    Conta contaAtualizar(ContaDto contaDto, int pk_conta);
    Conta pesquisarContaByUsername(String username);
    Conta pesquisarContaByPkConta(int pk_conta);
    List<Conta> contaDeletar(int pk_conta);
    UserDetails autenticarContaByUsername(String username);
    Conta authConta(AutenticacaoDto autenticacaoDto);
        
    
    
    
}
