/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package employee.com.employee_database.entities.services;

import employee.com.employee_database.entities.Produto;
import employee.com.employee_database.entities.dtos.ProdutoDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public interface ProdutoService {
    Produto produtoSalvar(ProdutoDto produto);
    List<Produto> produtoListar();
    //Produto produtoAtualizar(Produto produto, int pk_produto);
    List<Produto> produtoDeletar(int pk_produto);
    Produto produtoPesquisarByPkProduto(int pk_produto);
    Produto produtoPesquisarByNome(String nome);
    Produto buscarProdutoMaiorPreco();
    Produto produtoAtualizar(ProdutoDto produto, int pk_produto);
  
}
