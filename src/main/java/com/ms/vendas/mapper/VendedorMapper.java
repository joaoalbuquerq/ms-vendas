package com.ms.vendas.mapper;

import com.ms.vendas.dto.VendedorCadastroDTO;
import com.ms.vendas.dto.VendedorDetalheDTO;
import com.ms.vendas.entity.Vendedor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendedorMapper {

    VendedorDetalheDTO toDtoDeatil(Vendedor vendedor);
    Vendedor toEntity(VendedorCadastroDTO dto);

}
