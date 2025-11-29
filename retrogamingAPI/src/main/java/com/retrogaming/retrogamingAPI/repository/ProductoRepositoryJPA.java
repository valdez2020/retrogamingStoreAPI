package com.retrogaming.retrogamingAPI.repository;

import com.retrogaming.retrogamingAPI.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositoryJPA extends JpaRepository<Producto, Long> {

  List<Producto> searchByNombre(String nombre);

  List<Producto> findByNombreContaining(String nombre);

  List<Producto> findByPrecioLessThanEqual(Double precio);

  List<Producto> findByNombreContainingAndPrecioLessThanEqual(String nombre, Double precio);
}
