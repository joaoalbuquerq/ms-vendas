package com.ms.vendas.service;

import com.ms.vendas.dto.VendedorCadastroDTO;
import com.ms.vendas.entity.Vendedor;
import com.ms.vendas.mapper.VendedorMapper;
import com.ms.vendas.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;
    private final VendedorMapper vendedorMapper;

    public VendedorService(VendedorRepository vendedorRepository, VendedorMapper vendedorMapper){
        this.vendedorRepository = vendedorRepository;
        this.vendedorMapper = vendedorMapper;
    }

    @Transactional(rollbackOn = Exception.class)
    public Vendedor cadastrar(VendedorCadastroDTO dto) {

        var vendedor = vendedorMapper.toEntity(dto);
        return vendedorRepository.save(vendedor);

    }
}
