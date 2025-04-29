package com.ms.vendas.exception;

public class VendaNaoEncontradaException extends RuntimeException {
    public VendaNaoEncontradaException(String vendaInexistente) {
        super(vendaInexistente);
    }
}
