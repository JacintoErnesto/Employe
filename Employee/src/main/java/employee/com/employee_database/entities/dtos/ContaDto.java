/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.entities.dtos;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author jacinto
 */
@Data
public class ContaDto {
  
    private String username;
   
    private String password;

    private int fkContaTipo;
    
    private Date dataRegistro = new Date();
}
