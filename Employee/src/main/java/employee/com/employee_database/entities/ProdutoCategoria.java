/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
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
@Table(name = "produto_categoria")
@Data
public class ProdutoCategoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pk_produto_categoria;
    @NonNull
    private String designacao_produto_categoria;

    public ProdutoCategoria() {
    }

    

}
