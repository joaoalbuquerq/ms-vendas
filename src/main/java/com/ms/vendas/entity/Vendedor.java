package com.ms.vendas.entity;

import com.ms.vendas.enums.StatusVendedor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

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
    private String telefone;

    @NotNull
    private StatusVendedor statusVendedor;

}
