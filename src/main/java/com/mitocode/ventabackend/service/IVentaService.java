package com.mitocode.ventabackend.service;

import java.util.List;

import com.mitocode.ventabackend.model.Venta;

public interface IVentaService {

	List<Venta> listar();

	Venta listarPorId(Integer id);

//	Venta registrar(Venta ven);
	Venta registrarTransaccional(Venta ven);

}
