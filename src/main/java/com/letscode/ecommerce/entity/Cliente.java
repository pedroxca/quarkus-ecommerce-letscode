package com.letscode.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.letscode.ecommerce.models.PerfilEnum;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends PanacheEntityBase {
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email")
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "perfil_enum")
    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;
    @Column(name = "senha")
    private String senha;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "sobrenome")
    private String sobrenome;

    public Cliente(String nome, String sobrenome, String email, String sexo, String cpf, String senha,
            PerfilEnum perfil) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.sexo = sexo;
        this.cpf = cpf;
        this.senha = senha;
        this.perfil = perfil;
    }

}
