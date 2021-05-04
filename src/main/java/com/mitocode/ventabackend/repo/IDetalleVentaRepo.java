
package com.mitocode.ventabackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.ventabackend.model.DetalleVenta;

public interface IDetalleVentaRepo<det, id> extends JpaRepository<DetalleVenta, Integer> {

}
