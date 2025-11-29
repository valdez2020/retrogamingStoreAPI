package com.retrogaming.retrogamingAPI.repository;

import com.retrogaming.retrogamingAPI.model.Producto;
import com.retrogaming.retrogamingAPI.service.ProductoService;
import java.util.List;
import java.util.Optional;

public interface ProductoRepository{

  Producto guardaProducto(Producto nuevoProducto);

  void eliminarProducto(Producto productoEliminado);

  List<Producto> ListaProductos();


  Optional<Producto> buscarPorId(Long id);

  List<Producto> buscarProductosPorNombre(String nombre);
  List<Producto> buscarProductosPorPecio(Double precio);
  List<Producto> buscarProductosPorNombreYPrecios(String nombre, Double precio);
}
