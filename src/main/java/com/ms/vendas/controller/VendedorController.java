package com.ms.vendas.controller;

import com.ms.vendas.dto.VendedorAtualizacaoDTO;
import com.ms.vendas.dto.VendedorCadastroDTO;
import com.ms.vendas.dto.VendedorDetalheDTO;
import com.ms.vendas.enums.StatusVendedor;
import com.ms.vendas.mapper.VendedorMapper;
import com.ms.vendas.service.VendedorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<VendedorDetalheDTO>> listar(@RequestParam(required = false) StatusVendedor statusVendedor){
        return ResponseEntity.ok(vendedorMapper.toListDtoDetail(vendedorService.listar(statusVendedor)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDetalheDTO> pesquisarPorId(@PathVariable UUID id){
        return ResponseEntity.ok(vendedorMapper.toDtoDeatil(vendedorService.pesquisarPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorDetalheDTO> atualizar(@PathVariable UUID id, @RequestBody VendedorAtualizacaoDTO dto){
        return ResponseEntity.ok(vendedorMapper.toDtoDeatil(vendedorService.atualizar(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> inativar(@PathVariable UUID id){
        vendedorService.inativar(id);
        return ResponseEntity.notFound().build();
    }

}
