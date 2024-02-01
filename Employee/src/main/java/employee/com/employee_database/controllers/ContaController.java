/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.controllers;

import employee.com.employee_database.entities.Conta;
import employee.com.employee_database.entities.dtos.AutenticacaoDto;
import employee.com.employee_database.entities.dtos.ContaDto;
import employee.com.employee_database.entities.services.ContaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jacinto
 */
@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping("/contaListar")
    public ResponseEntity<List<Conta>> contaListar() {
        List<Conta> contaListar = this.contaService.contaListar();
        if (contaListar != null) {
            return ResponseEntity.status(HttpStatus.OK).body(contaListar);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("/contaSalvar")
    public ResponseEntity<Conta> contaSalvar(@RequestBody ContaDto conta) {

        Conta contaSalvar = this.contaService.contaSalvar(conta);

        if (contaSalvar == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(contaSalvar);

    }

    @PostMapping("/contaAtualizar/{pk_conta}")
    public ResponseEntity<Conta> contaAtualizar(@RequestBody ContaDto conta, @PathVariable(value = "pk_conta") int pk_conta) {

        Conta contaAtualizar = this.contaService.contaAtualizar(conta, pk_conta);

        if (contaAtualizar == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(contaAtualizar);

    }

    @DeleteMapping("/contaDeletar/{pk_conta}")
    public ResponseEntity<List<Conta>> contaDeletar(@PathVariable(value = "pk_conta") int pk_conta) {
        List<Conta> contaDeletar = this.contaService.contaDeletar(pk_conta);
        if (contaDeletar != null) {
            return ResponseEntity.status(HttpStatus.OK).body(contaDeletar);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/pesquisarContaByUsername/{username}")
    public ResponseEntity<Conta> pesquisarContaByUsername(@PathVariable(value = "username") String username) {
        Conta pesquisarContaByUsername = this.contaService.pesquisarContaByUsername(username);
        if (pesquisarContaByUsername != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pesquisarContaByUsername);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/pesquisarContaByPkConta/{pk_conta}")
    public ResponseEntity<Conta> pesquisarContaByPkConta(@PathVariable(value = "pk_conta") int pk_conta) {
        Conta pesquisarContaByPkConta = this.contaService.pesquisarContaByPkConta(pk_conta);
        if (pesquisarContaByPkConta != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pesquisarContaByPkConta);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("/authConta")
    public ResponseEntity<Conta> authConta(@Validated @RequestBody AutenticacaoDto autenticacaoDto) {
        Conta authConta = this.contaService.authConta(autenticacaoDto);
       
        if (authConta != null) {
            return ResponseEntity.ok(authConta);

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

}
