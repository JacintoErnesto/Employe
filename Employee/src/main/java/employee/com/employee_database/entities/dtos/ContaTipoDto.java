/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.entities.dtos;

import java.util.Date;
import lombok.Data;
import lombok.NonNull;

/**
 *
 * @author jacinto
 */
@Data
public class ContaTipoDto {
   
    private String designacao;
  
    private final Date dataRegistro = new Date();

    
}
