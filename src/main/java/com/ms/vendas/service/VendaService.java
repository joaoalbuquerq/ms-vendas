package com.ms.vendas.service;

import com.ms.vendas.dto.VendaAtualizacaoDTO;
import com.ms.vendas.dto.VendaCadastroDTO;
import com.ms.vendas.entity.Venda;
import com.ms.vendas.enums.StatusVenda;
import com.ms.vendas.exception.VendaNaoEncontradaException;
import com.ms.vendas.mapper.VendaMapper;
import com.ms.vendas.repository.VendaRepository;
import com.ms.vendas.repository.VendedorRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class VendaService {

    private final VendaRepository vendaRepository;
    private final VendaMapper vendaMapper;

    public VendaService(VendaRepository vendaRepository, VendaMapper vendaMapper){
        this.vendaMapper = vendaMapper;
        this.vendaRepository = vendaRepository;
    }

    @Transactional
    public Venda cadastrar(VendaCadastroDTO dto) {
        var venda = vendaMapper.toEntity(dto);
        venda.setUltimaAlteracao(LocalDateTime.now());
        venda.setDataRealizacao(LocalDateTime.now());
        venda.setStatusVenda(StatusVenda.PENDENTE);

        return vendaRepository.save(venda);
    }

    @Transactional(readOnly = true)
    public Venda pesquisarPorId(UUID id) {
        return vendaRepository.findById(id).orElseThrow(() -> new VendaNaoEncontradaException("Venda inexistente"));
    }

    @Transactional(readOnly = true)
    public List<Venda> listar() {
        return vendaRepository.findAll();
    }

    @Transactional
    public Venda atualizar(UUID id, VendaAtualizacaoDTO dto) {
        Venda venda = pesquisarPorId(id);
        return null;
    }

    @Transactional
    public Venda excluir(UUID id) {
        return null;
    }
}
