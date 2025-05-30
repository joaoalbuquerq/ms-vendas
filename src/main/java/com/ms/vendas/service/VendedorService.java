package com.ms.vendas.service;

import com.ms.vendas.dto.VendedorAtualizacaoDTO;
import com.ms.vendas.dto.VendedorCadastroDTO;
import com.ms.vendas.dto.VendedorDetalheDTO;
import com.ms.vendas.entity.Vendedor;
import com.ms.vendas.enums.StatusVendedor;
import com.ms.vendas.exception.VendedorInativadoExpcetion;
import com.ms.vendas.exception.VendedorNaoEncontradoException;
import com.ms.vendas.mapper.VendedorMapper;
import com.ms.vendas.repository.VendedorRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;
    private final VendedorMapper vendedorMapper;

    public VendedorService(VendedorRepository vendedorRepository, VendedorMapper vendedorMapper){
        this.vendedorRepository = vendedorRepository;
        this.vendedorMapper = vendedorMapper;
    }

    @Transactional
    public Vendedor cadastrar(VendedorCadastroDTO dto) {

        var vendedor = vendedorMapper.toEntity(dto);
        vendedor.setStatusVendedor(StatusVendedor.ATIVO);
        vendedor.setUltimaAlteracao(LocalDateTime.now());
        vendedor.setDataCriacao(LocalDateTime.now());
        return vendedorRepository.save(vendedor);

    }
    @Transactional(readOnly = true)
    public List<Vendedor> listar(StatusVendedor statusVendedor) {
        if(statusVendedor == null){
            return vendedorRepository.findAll();
        }
        return vendedorRepository.findAllByStatusVendedor(statusVendedor);
    }

    @Transactional(readOnly = true)
    public Vendedor pesquisarPorId(UUID id) {
        return vendedorRepository.findById(id).orElseThrow(() -> new VendedorNaoEncontradoException("Vendedor não existe na base de dados"));
    }

    @Transactional()
    public Vendedor atualizar(UUID id, VendedorAtualizacaoDTO dto) {
        Vendedor vendedor = pesquisarPorId(id);
        vendedor = vendedorMapper.updateVendedorFromDto(dto, vendedor);
        vendedor.setUltimaAlteracao(LocalDateTime.now());
        return vendedorRepository.save(vendedor);
    }

    @Transactional()
    public void inativar(UUID id) {
        Vendedor vendedor = pesquisarPorId(id);
        if(vendedor.getStatusVendedor() == StatusVendedor.INATIVO){
            throw new VendedorInativadoExpcetion("Vendedor: " + vendedor.getNome() + " se encontra INATIVO");
        }
        vendedor.setStatusVendedor(StatusVendedor.INATIVO);
        vendedor.setUltimaAlteracao(LocalDateTime.now());
        vendedorRepository.save(vendedor);
    }
}
