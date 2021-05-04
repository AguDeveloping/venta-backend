package com.mitocode.ventabackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.ventabackend.exception.ModeloNotFoundException;
import com.mitocode.ventabackend.model.Producto;
import com.mitocode.ventabackend.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService service;

	@GetMapping
	public ResponseEntity<List<Producto>> listar() {
		List<Producto> lista = service.listar();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) {
		Producto prod = service.listarPorId(id);

		if (prod == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Producto>(prod, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto p) {
		Producto prod = service.registrar(p);
		return new ResponseEntity<Producto>(prod, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto p) {
		Producto prod = service.modificar(p);
		return new ResponseEntity<Producto>(prod, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
		// busca el registro por id.
		Producto prod = service.listarPorId(id);
		if (prod == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		// elimina el registro encontrado.
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
