package com.retrogaming.retrogamingAPI.service;

import com.retrogaming.retrogamingAPI.entity.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService  {

  Producto crearProducto(Producto nuevoProducto);

  List<Producto> mostrarProductos();

  List<Producto> filtrarProductos(String nombre, Double precio);

  Producto buscarProductoPorId(Long id);
  Producto editarProductoPorId(Long id, Producto datosEditados);

  Producto eliminarProducto(Long id);

}
