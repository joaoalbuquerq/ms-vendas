package com.ms.vendas.dto;

import com.ms.vendas.enums.StatusVendedor;

public record VendedorDetalheDTO(
        String nome,
        String telefone,
        String email,
        StatusVendedor statusVendedor
) {
}
