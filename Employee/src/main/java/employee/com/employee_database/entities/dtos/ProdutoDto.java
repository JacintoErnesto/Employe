/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.entities.dtos;

import lombok.Data;

/**
 *
 * @author jacinto
 */
@Data
public class ProdutoDto {
    private String nome;
    private String codigo;
    private float preco;
    private int fk_produto_categoria;
}
