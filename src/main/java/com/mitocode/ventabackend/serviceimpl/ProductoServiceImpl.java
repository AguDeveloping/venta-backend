package com.mitocode.ventabackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.ventabackend.model.Producto;
import com.mitocode.ventabackend.repo.IProductoRepo;
import com.mitocode.ventabackend.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo<Producto, Integer> repo;

	@Override
	public Producto registrar(Producto prod) {
		return repo.save(prod);
	}

	@Override
	public Producto modificar(Producto prod) {
		return repo.save(prod);
	}

	@Override
	public List<Producto> listar() {
		return repo.findAll();
	}

	@Override
	public Producto listarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);

	}

}
