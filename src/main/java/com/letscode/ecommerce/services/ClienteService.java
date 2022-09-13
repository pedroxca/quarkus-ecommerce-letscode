package com.letscode.ecommerce.services;

import com.letscode.ecommerce.entity.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente findByEmail(String email);

    Cliente salvar(Cliente cliente);

    Cliente atualizar(Cliente cliente);

    void excluir(long id);

    Cliente getById(long id);

    List<Cliente> getAll();

}