/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.controllers;

import employee.com.employee_database.entities.ContaTipo;
import employee.com.employee_database.entities.dtos.ContaTipoDto;
import employee.com.employee_database.entities.services.ContaTipoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jacinto
 */
@RestController
@RequestMapping("/conta_tipo")
public class ContaTipoController {
    
    private final ContaTipoService contaTipoService;

    public ContaTipoController(ContaTipoService contaTipoService) {
        this.contaTipoService = contaTipoService;
    }
    
    @GetMapping("/contaTipoListar")
    public ResponseEntity<List<ContaTipo>> contaTipoListar(){
        List<ContaTipo> contaTipoListar = this.contaTipoService.contaTipoListar();
        if(contaTipoListar != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(contaTipoListar);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    
    @PostMapping("/contaTipoSalvar")
    public ResponseEntity<ContaTipo> contaTipoSalvar(@RequestBody ContaTipoDto contaTipoDto){
        ContaTipo contaTipoSalvar = this.contaTipoService.contaTipoSalvar(contaTipoDto);
        if(contaTipoSalvar != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(contaTipoSalvar);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    
    @PutMapping("/contaTipoAtualizar/{pk_conta_tipo}")
    public ResponseEntity<ContaTipo> contaTipoAtualizar(@RequestBody ContaTipoDto contaTipoDto, @PathVariable(value = "pk_conta_tipo") int pk_conta_tipo){
        ContaTipo contaTipoAtualizar = this.contaTipoService.contaTipoAtualizar(contaTipoDto, pk_conta_tipo);
        if(contaTipoAtualizar != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(contaTipoAtualizar);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    
}
