/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.entities.services.Impl;

import employee.com.employee_database.entities.ProdutoCategoria;
import employee.com.employee_database.entities.repositories.ProdutoCategoriaRepository;
import employee.com.employee_database.entities.services.ProdutoCategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public class ProdutoCategoriaServiceImpl implements ProdutoCategoriaService{
    @Autowired
    private ProdutoCategoriaRepository produtoCategoriaRepository;

    public ProdutoCategoriaServiceImpl(ProdutoCategoriaRepository produtoCategoriaRepository) {
        this.produtoCategoriaRepository = produtoCategoriaRepository;
    }

    @Override
    public List<ProdutoCategoria> produtoCategoriaListar() {
        List<ProdutoCategoria> produtoCategoriaListar = this.produtoCategoriaRepository.produtoCategoriaListar();
        if (produtoCategoriaListar == null){
            return null;
        }
        return produtoCategoriaListar;
    }

    @Override
    public ProdutoCategoria produtoCategoriaSalvar(ProdutoCategoria produtoCategoria) {
        ProdutoCategoria produtoCategoriaSalvar = new ProdutoCategoria();
        produtoCategoriaSalvar.setDesignacao_produto_categoria(produtoCategoria.getDesignacao_produto_categoria());
        return this.produtoCategoriaRepository.save(produtoCategoriaSalvar);
        
    }

    @Override
    public ProdutoCategoria produtoCategoriaByDesignacao(String designacao_produto_categoria) {
        ProdutoCategoria buscarProdutoCategoria = this.produtoCategoriaRepository.produtoCategoriaByDesignacao(designacao_produto_categoria);
        if (buscarProdutoCategoria == null){
            return null;
        }
        return buscarProdutoCategoria;
    }

    @Override
    public ProdutoCategoria buscarCategoriaProdutoByPkProdutoCategoria(int pk_produto_categoria) {
        ProdutoCategoria buscarProdutoCategoria = this.produtoCategoriaRepository.buscarCategoriaProdutoByPkProdutoCategoria(pk_produto_categoria);
        if (buscarProdutoCategoria == null){
            return null;
        }
        return buscarProdutoCategoria;
    }
    
    
    
}
