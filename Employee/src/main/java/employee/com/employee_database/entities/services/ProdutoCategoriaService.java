/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package employee.com.employee_database.entities.services;

import employee.com.employee_database.entities.ProdutoCategoria;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public interface ProdutoCategoriaService {
    List<ProdutoCategoria> produtoCategoriaListar();
    ProdutoCategoria produtoCategoriaSalvar(ProdutoCategoria produtoCategoria); 
    public ProdutoCategoria produtoCategoriaByDesignacao(String designacao_produto_categoria);
    public ProdutoCategoria buscarCategoriaProdutoByPkProdutoCategoria(int pk_produto_categoria);
    
}
