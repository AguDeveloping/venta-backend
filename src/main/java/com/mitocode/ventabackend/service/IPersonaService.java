package com.mitocode.ventabackend.service;

import java.util.List;

import com.mitocode.ventabackend.model.Persona;

public interface IPersonaService {

	Persona registrar(Persona per);

	Persona modificar(Persona per);

	List<Persona> listar();

	Persona listarPorId(Integer id);

	void eliminar(Integer id);
}
