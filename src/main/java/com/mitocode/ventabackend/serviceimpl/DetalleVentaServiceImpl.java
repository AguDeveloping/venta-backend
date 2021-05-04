package com.mitocode.ventabackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.ventabackend.model.DetalleVenta;
import com.mitocode.ventabackend.repo.IDetalleVentaRepo;
import com.mitocode.ventabackend.service.IDetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

	@Autowired
	private IDetalleVentaRepo<DetalleVenta, Integer> repo;

	@Override
	public DetalleVenta registrar(DetalleVenta det) {
		return repo.save(det);
	}

	@Override
	public List<DetalleVenta> listar() {
		return repo.findAll();
	}
}
