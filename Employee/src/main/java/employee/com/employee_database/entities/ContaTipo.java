/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NonNull;

/**
 *
 * @author jacinto
 */
@Entity
@Table(name = "conta_tipo")
@Data
public class ContaTipo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="pk_conta_tipo" )
    private int pkContaTipo;
    @Column(name ="designacao" )
    @NonNull
    private String designacao;
    @Column(name ="data_registro")
    private final Date dataRegistro = new Date();

    public ContaTipo() {
    }
}
