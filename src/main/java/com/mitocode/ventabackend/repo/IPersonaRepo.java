package com.mitocode.ventabackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.ventabackend.model.Persona;

public interface IPersonaRepo<per, id> extends JpaRepository<Persona, Integer> {

}
