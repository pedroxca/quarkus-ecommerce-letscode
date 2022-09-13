package com.letscode.ecommerce.services.implementation;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.letscode.ecommerce.dao.ProdutoDao;
import com.letscode.ecommerce.entity.Produto;
import com.letscode.ecommerce.services.ProdutoService;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

  @Inject
  ProdutoDao produtoDao;

  @Transactional
  public List<Produto> getProdutos() {
    return produtoDao.findAll().list();
  }

  @Transactional
  public Produto getProdutoById(Long id) {
    Optional<Produto> produtoOptional = Optional.of(produtoDao.findById(id));
    if (!produtoOptional.isPresent()) {
      throw new RuntimeException("Produto inexistente");
    }
    return produtoOptional.get();
  }

  @Transactional
  public Produto updateProduto(Produto produto) {
    produtoDao.getEntityManager().merge(produto);
    return produto;
  }

  @Transactional
  public Produto createProduto(Produto produto) {
    produtoDao.persist(produto);
    return produto;
  }

  @Transactional
  public void deleteProduto(Long id) {
    produtoDao.deleteById(id);
  }

}
