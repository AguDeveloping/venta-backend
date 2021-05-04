package com.mitocode.ventabackend.service;

import java.util.List;

import com.mitocode.ventabackend.model.Producto;

public interface IProductoService {

	Producto registrar(Producto prod);

	Producto modificar(Producto prod);

	List<Producto> listar();

	Producto listarPorId(Integer id);

	void eliminar(Integer id);
}
