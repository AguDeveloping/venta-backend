package com.mitocode.ventabackend.exception;

public class ModeloNotFoundException extends RuntimeException {

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
