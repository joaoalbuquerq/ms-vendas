package com.ms.vendas.controller;

import com.ms.vendas.dto.VendedorCadastroDTO;
import com.ms.vendas.dto.VendedorDetalheDTO;
import com.ms.vendas.mapper.VendedorMapper;
import com.ms.vendas.service.VendedorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorController {

    private final VendedorService vendedorService;
    private final VendedorMapper vendedorMapper;

    public VendedorController(VendedorService vendedorService, VendedorMapper vendedorMapper){
        this.vendedorService = vendedorService;
        this.vendedorMapper = vendedorMapper;
    }

    @PostMapping
    public ResponseEntity<VendedorDetalheDTO> cadastrar(@RequestBody @Valid VendedorCadastroDTO dto){

        var vendedor = vendedorService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedorMapper.toDtoDeatil(vendedor));
    }

}
