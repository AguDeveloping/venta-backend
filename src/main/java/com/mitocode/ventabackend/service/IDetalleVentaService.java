package com.mitocode.ventabackend.service;

import java.util.List;

import com.mitocode.ventabackend.model.DetalleVenta;

public interface IDetalleVentaService {

	DetalleVenta registrar(DetalleVenta det);

	List<DetalleVenta> listar();

}
