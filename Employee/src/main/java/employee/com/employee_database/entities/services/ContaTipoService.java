/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package employee.com.employee_database.entities.services;

import employee.com.employee_database.entities.ContaTipo;
import employee.com.employee_database.entities.dtos.ContaTipoDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public interface ContaTipoService {

    List<ContaTipo> contaTipoListar();

    ContaTipo contaTipoSalvar(ContaTipoDto contaTipoDto);

    public ContaTipo contaTipoAtualizar(ContaTipoDto contaTipoDto, int pk_conta_tipo);

}
