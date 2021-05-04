package com.mitocode.ventabackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.ventabackend.model.Persona;
import com.mitocode.ventabackend.repo.IPersonaRepo;
import com.mitocode.ventabackend.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepo<Persona, Integer> repo;

	@Override
	public Persona registrar(Persona per) {
		return repo.save(per);
	}

	@Override
	public Persona modificar(Persona per) {
		return repo.save(per);
	}

	@Override
	public List<Persona> listar() {
		return repo.findAll();
	}

	@Override
	public Persona listarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);

	}

}
