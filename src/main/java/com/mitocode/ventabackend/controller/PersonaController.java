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
import com.mitocode.ventabackend.model.Persona;
import com.mitocode.ventabackend.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService service;

	@GetMapping
	public ResponseEntity<List<Persona>> listar() {
		List<Persona> lista = service.listar();
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) {
		Persona per = service.listarPorId(id);

		if (per == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Persona>(per, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Persona> registrar(@Valid @RequestBody Persona p) {
		Persona per = service.registrar(p);
		return new ResponseEntity<Persona>(per, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona p) {
		Persona per = service.modificar(p);
		return new ResponseEntity<Persona>(per, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
		// busca el registro por id.
		Persona per = service.listarPorId(id);
		if (per == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		// elimina el registro encontrado.
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
