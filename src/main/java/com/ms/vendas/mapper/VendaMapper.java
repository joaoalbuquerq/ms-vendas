package com.ms.vendas.mapper;

import com.ms.vendas.dto.VendaCadastroDTO;
import com.ms.vendas.dto.VendaDetailDTO;
import com.ms.vendas.entity.Venda;

public interface VendaMapper {

    Venda toEntity(VendaCadastroDTO dto);

    VendaDetailDTO toDeatil(Venda venda);
}
