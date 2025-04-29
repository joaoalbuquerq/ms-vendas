package com.ms.vendas.entity;

import com.ms.vendas.enums.StatusVendedor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String nome;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String cpf;

    @NotNull
    private String telefone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusVendedor statusVendedor;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venda> vendas;

    @NotNull
    private LocalDateTime dataCriacao;

    @NotNull
    private LocalDateTime ultimaAlteracao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public StatusVendedor getStatusVendedor() {
        return statusVendedor;
    }

    public void setStatusVendedor(StatusVendedor statusVendedor) {
        this.statusVendedor = statusVendedor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(LocalDateTime ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}
