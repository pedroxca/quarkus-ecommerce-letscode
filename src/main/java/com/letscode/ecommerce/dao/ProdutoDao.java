package com.letscode.ecommerce.dao;

import javax.enterprise.context.ApplicationScoped;

import com.letscode.ecommerce.entity.Produto;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class ProdutoDao implements PanacheRepositoryBase<Produto, Long> {
  
}
