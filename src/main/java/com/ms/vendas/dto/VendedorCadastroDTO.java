package com.ms.vendas.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VendedorCadastroDTO(
    @NotBlank(message = "O nome é um campo obrigatório")
    String nome,

    @NotBlank(message = "O cpf é um campo obrigatório")
    @Pattern(regexp = "^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$", message = "CPF inválido. Formato esperado: 123.456.789-09 ou 12345678909")
    String cpf,

    @NotBlank(message = "O telefone é um campo obrigatório")
    @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$", message = "Telefone inválido. Formato esperado: (11) 91234-5678 ou 11912345678")
    String telefone,

    @NotBlank(message = "O email é um campo obrigatório")
    @Email
    String email
) {
}
