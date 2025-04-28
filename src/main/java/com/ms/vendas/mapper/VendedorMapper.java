package com.ms.vendas.mapper;

import com.ms.vendas.dto.VendedorAtualizacaoDTO;
import com.ms.vendas.dto.VendedorCadastroDTO;
import com.ms.vendas.dto.VendedorDetalheDTO;
import com.ms.vendas.entity.Vendedor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VendedorMapper {

    VendedorDetalheDTO toDtoDeatil(Vendedor vendedor);
    Vendedor toEntity(VendedorCadastroDTO dto);
    List<VendedorDetalheDTO> toListDtoDetail(List<Vendedor> lista);
    Vendedor updateVendedorFromDto(VendedorAtualizacaoDTO dto, @MappingTarget Vendedor vendedor);

}
