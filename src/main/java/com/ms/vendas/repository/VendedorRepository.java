package com.ms.vendas.repository;

import com.ms.vendas.entity.Vendedor;
import com.ms.vendas.enums.StatusVendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, UUID> {

    List<Vendedor> findAllByStatusVendedor(StatusVendedor statusVendedor);
}
