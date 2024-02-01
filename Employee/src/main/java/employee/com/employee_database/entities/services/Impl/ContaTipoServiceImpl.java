/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.entities.services.Impl;

import employee.com.employee_database.entities.ContaTipo;
import employee.com.employee_database.entities.dtos.ContaTipoDto;
import employee.com.employee_database.entities.repositories.ContaTipoRepository;
import employee.com.employee_database.entities.services.ContaTipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public class ContaTipoServiceImpl implements ContaTipoService{
    
    @Autowired
    private final ContaTipoRepository contaTipoReoository;

    public ContaTipoServiceImpl(ContaTipoRepository contaTipoReoository) {
        this.contaTipoReoository = contaTipoReoository;
    }
    

    @Override
    public ContaTipo contaTipoSalvar(ContaTipoDto contaTipoDto) {
        if (this.contaTipoReoository.existsByDesignacao(contaTipoDto.getDesignacao()) == null){
            ContaTipo contaTipoSalvar = new ContaTipo();
            contaTipoSalvar.setDesignacao(contaTipoDto.getDesignacao());
            return this.contaTipoReoository.save(contaTipoSalvar);
        }
        return null;
        
    }

    @Override
    public List<ContaTipo> contaTipoListar() {
        List<ContaTipo> contaTipoListar = this.contaTipoReoository.contaTipoListar();
        if(contaTipoListar != null)
        {
            return contaTipoListar;
        }
        return  null;
    }

    @Override
    public ContaTipo contaTipoAtualizar(ContaTipoDto contaTipoDto, int pk_conta_tipo) {
        ContaTipo contaTipoAtualizar = this.contaTipoReoository.existsByPkContaTipo(pk_conta_tipo);
        if (contaTipoAtualizar != null){
            
            contaTipoAtualizar.setDesignacao(contaTipoDto.getDesignacao());
            return this.contaTipoReoository.save(contaTipoAtualizar);
        }
        return null;
    }
    
}
