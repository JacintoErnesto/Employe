/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package employee.com.employee_database.entities.repositories;

import employee.com.employee_database.entities.ProdutoCategoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jacinto
 */
public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoria, Integer> {

    @Query(value = "SELECT * FROM public.produto_categoria\n"
            + "ORDER BY designacao_produto_categoria ", nativeQuery = true)
    public List<ProdutoCategoria> produtoCategoriaListar();

    @Query(value = "SELECT * FROM public.produto_categoria WHERE designacao_produto_categoria = ?1", nativeQuery = true)
    public ProdutoCategoria produtoCategoriaByDesignacao(String designacao_produto_categoria);

    @Query(value = "SELECT * FROM public.produto_categoria WHERE pk_produto_categoria = ?1", nativeQuery = true)
    public ProdutoCategoria buscarCategoriaProdutoByPkProdutoCategoria(int fk_produto_categoria);

}
