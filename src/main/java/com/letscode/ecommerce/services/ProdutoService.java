package com.letscode.ecommerce.services;

import java.util.List;

import com.letscode.ecommerce.entity.Produto;

public interface ProdutoService {
  public List<Produto> getProdutos();

  public Produto getProdutoById(Long id);

  public Produto updateProduto(Produto produto);
  public Produto createProduto(Produto produto);

  public void deleteProduto(Long id);
}
