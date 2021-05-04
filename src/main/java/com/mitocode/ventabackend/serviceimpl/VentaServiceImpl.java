package com.mitocode.ventabackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.ventabackend.model.Venta;
import com.mitocode.ventabackend.repo.IVentaRepo;
import com.mitocode.ventabackend.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepo<Venta, Integer> repo;

	@Override
	public List<Venta> listar() {
		return repo.findAll();
	}

	@Override
	public Venta listarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Venta registrarTransaccional(Venta ven) {

		ven.getDetalleVenta().forEach(det -> det.setVenta(ven));

		return repo.save(ven);
	}

}
