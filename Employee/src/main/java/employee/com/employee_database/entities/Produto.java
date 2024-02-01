/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author jacinto
 */
@Entity
@Table(name = "produto")
@Data
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int pk_produto;
    private String nome;
    private String codigo;
    private float preco;
    @ManyToOne
    private ProdutoCategoria fk_produto_categoria;
    

    public Produto() {
      
    }

//    @JsonIgnore
//    @JoinColumn(name = "fk_produto_categoria", referencedColumnName = "pk_produto_categoria")
//
//    private int fk_produto_categoria;
}
