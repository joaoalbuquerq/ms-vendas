package com.ms.vendas.controller;

import com.ms.vendas.dto.VendaAtualizacaoDTO;
import com.ms.vendas.dto.VendaCadastroDTO;
import com.ms.vendas.dto.VendaDetailDTO;
import com.ms.vendas.entity.Venda;
import com.ms.vendas.mapper.VendaMapper;
import com.ms.vendas.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/venda")
public class VendasController {

    private final VendaService vendaService;
    private final VendaMapper vendaMapper;

    public VendasController(VendaService vendaService, VendaMapper vendaMapper){
        this.vendaService = vendaService;
        this.vendaMapper = vendaMapper;
    }

    @PostMapping
    public ResponseEntity<VendaDetailDTO> cadastrar(@RequestBody @Valid VendaCadastroDTO dto){
        Venda venda = vendaService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaMapper.toDeatil(venda));
    }

    @GetMapping
    public ResponseEntity<List<VendaDetailDTO>> listar(){
        vendaService.listar();
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDetailDTO> pesquisarPorId(@PathVariable UUID id){
        vendaService.pesquisarPorId(id);
        return null;
    }

    @PutMapping("{/id}")
    public ResponseEntity<VendaDetailDTO> atualizar(@PathVariable UUID id, @RequestBody VendaAtualizacaoDTO dto){
        vendaService.atualizar(id, dto);
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable UUID id){
        vendaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
