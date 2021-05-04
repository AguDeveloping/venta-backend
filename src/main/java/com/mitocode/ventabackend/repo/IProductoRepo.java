package com.mitocode.ventabackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.ventabackend.model.Producto;

public interface IProductoRepo<prod, id> extends JpaRepository<Producto, Integer> {

}
