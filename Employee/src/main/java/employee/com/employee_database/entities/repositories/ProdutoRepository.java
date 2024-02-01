/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package employee.com.employee_database.entities.repositories;

import employee.com.employee_database.entities.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jacinto
 */
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(value = "SELECT * FROM produto WHERE nome = ?1 OR codigo = ?2", nativeQuery = true)
    public Produto produtoExists(String nome, String codigo);
    public Boolean existsByNomeOrCodigo(String nome,String codigo);
    @Query(value = "SELECT * FROM produto ORDER BY nome", nativeQuery = true)
    public List<Produto> findAllProdutoOrderByNome();

    @Query(value = "SELECT * FROM produto WHERE nome = ?1", nativeQuery = true)
    public Produto produtoPequisarByNome(String nome);
    
    public Produto findByNome(String nome);
    
    
    @Query(value = "SELECT * FROM produto WHERE pk_produto = ?1", nativeQuery = true)
    public Produto produtoPequisarByPkProduto(int pk_produto);

    @Query(value = "SELECT * FROM produto ORDER BY preco DESC LIMIT 1", nativeQuery = true)
    public Produto buscarProdutoMaiorPreco();
    
    

}
