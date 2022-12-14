package com.letscode.ecommerce.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@NonNull
@Entity
@Getter
@Setter
@Table(name = "produto")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome", nullable = false)
  private String nome;
  @Column(name = "preco", nullable = false, columnDefinition = "DECIMAL(7,2)")
  private BigDecimal preco = BigDecimal.valueOf(0L);

  @Column(name = "descricao", nullable = false)
  private String descricao;

  public Produto(Long id, String nome, String preco, String descricao) {
    this.id = id;
    this.nome = nome;
    this.preco = new BigDecimal(preco);
    this.descricao = descricao;
  }

  public Produto(String nome, String preco, String descricao) {
    this.nome = nome;
    this.preco = new BigDecimal(preco);
    this.descricao = descricao;
  }

  public Produto() {
  }

  public String getPreco() {
    return preco.setScale(2).toString();
  }

  public void setPreco(String price) {
    this.preco = new BigDecimal(price);
  }

  @Override
  public String toString() {
    return String.format("{id=%s, nome=%s, descricao=%s, preco=%s}", id, nome, descricao, preco);
  }

}
