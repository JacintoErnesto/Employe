/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.entities.services.Impl;

import employee.com.employee_database.entities.Conta;
import employee.com.employee_database.entities.ContaTipo;
import employee.com.employee_database.entities.dtos.AutenticacaoDto;
import employee.com.employee_database.entities.dtos.ContaDto;
import employee.com.employee_database.entities.repositories.ContaRepository;
import employee.com.employee_database.entities.repositories.ContaTipoRepository;
import employee.com.employee_database.entities.services.ContaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private final ContaRepository contaRepository;

    @Autowired
    private ContaTipoRepository contaTipoRepository;

    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;

    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public List<Conta> contaListar() {
        List<Conta> contaListar = this.contaRepository.contaListar();
        if (contaListar != null) {
            return contaListar;
        }
        return null;
    }

    @Override
    public Conta contaSalvar(ContaDto contaDto) {
        if (this.contaRepository.pesquisarContaByUsername(contaDto.getUsername()) == null) {
            Conta contaSalvar = new Conta();
            contaSalvar.setUsername(contaDto.getUsername());
            contaSalvar.setPassword(passwordEncoder().encode(contaDto.getPassword()));
            ContaTipo contaTipo = this.contaTipoRepository.existsByPkContaTipo(contaDto.getFkContaTipo());
            if (contaTipo == null) {
                return null;
            }
            contaSalvar.setFkContaTipo(contaTipo);

            return contaRepository.save(contaSalvar);

        }
        return null;
    }

    @Override
    public Conta contaAtualizar(ContaDto contaDto, int pk_conta) {
        Conta contaAtualizar = this.contaRepository.pesquisarContaByPkConta(pk_conta);
        if (contaAtualizar != null) {
            contaAtualizar.setUsername(contaDto.getUsername());
            contaAtualizar.setPassword(passwordEncoder().encode(contaDto.getPassword()));
            ContaTipo contaTipo = this.contaTipoRepository.existsByPkContaTipo(contaDto.getFkContaTipo());
            if (contaTipo == null) {
                return null;
            }
            contaAtualizar.setFkContaTipo(contaTipo);

            return contaRepository.save(contaAtualizar);

        }
        return null;
    }

    @Override
    public Conta pesquisarContaByUsername(String username) {
        Conta pesquisarContaByUsername = this.contaRepository.pesquisarContaByUsername(username);
        if (pesquisarContaByUsername != null) {
            return pesquisarContaByUsername;
        }
        return null;
    }

    @Override
    public Conta pesquisarContaByPkConta(int pk_conta) {
        Conta pesquisarContaByPkConta = this.contaRepository.pesquisarContaByPkConta(pk_conta);
        if (pesquisarContaByPkConta != null) {
            return pesquisarContaByPkConta;
        }
        return null;
    }

    @Override
    public List<Conta> contaDeletar(int pk_conta) {
        Conta contaDeletar = this.contaRepository.pesquisarContaByPkConta(pk_conta);
        if (contaDeletar != null) {
            contaRepository.delete(contaDeletar);
            return contaListar();
        }
        return null;
    }

    @Override
    public UserDetails autenticarContaByUsername(String username)throws UsernameNotFoundException
    {
        return this.contaRepository.autenticarContaByUsername(username);
        
    }

    @Override
    public Conta authConta(AutenticacaoDto autenticacaoDto) {
            
        Conta authConta = this.pesquisarContaByUsername(autenticacaoDto.getUsername());
 
        if (authConta != null){
            
            if (passwordEncoder().matches(autenticacaoDto.getPassword(), authConta.getPassword()))
            {
                
                return authConta;
           
            }
          
        }
        return null;
    }

}
