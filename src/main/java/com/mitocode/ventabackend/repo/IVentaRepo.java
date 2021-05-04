
package com.mitocode.ventabackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.ventabackend.model.Venta;

public interface IVentaRepo<ven, id> extends JpaRepository<Venta, Integer> {

}
