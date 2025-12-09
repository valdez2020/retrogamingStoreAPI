package com.retrogaming.retrogamingAPI.service;

import com.retrogaming.retrogamingAPI.entity.Producto;
import com.retrogaming.retrogamingAPI.repository.ProductoDBRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoDBService implements ProductoService {

  @Autowired
  ProductoDBRepository repository;

  @Override
  public Producto crearProducto(Producto nuevoProducto){

    return this.repository.guardaProducto(nuevoProducto);
  }

  @Override
public List<Producto> mostrarProductos(){
    return this.repository.ListaProductos();
}

  @Override
  public List<Producto> filtrarProductos(String nombre, Double precio) {
    if(!nombre.isEmpty() && precio > 0){
      return this.repository.buscarProductosPorNombreYPrecios(nombre, precio);
    }
    if (!nombre.isEmpty()){
      return this.repository.buscarProductosPorNombre(nombre);
    }
    if (precio > 0){
      return this.repository.buscarProductosPorPecio(precio);
    }

    return this.repository.ListaProductos();
  }

  @Override
  public Producto buscarProductoPorId(Long id) {
    Optional<Producto> productoBuscado = this.repository.buscarPorId(id);

    if (productoBuscado.isEmpty()){
      throw new RuntimeException("El producto con ID:" + id + " No existe...");
    }

    return  productoBuscado.get();
  }

  @Override
  public Producto editarProductoPorId(Long id, Producto datosEditados) {
  Optional<Producto> productoBuscado = this.repository.buscarPorId(id);

  if (productoBuscado.isEmpty()){
    throw new RuntimeException("El producto con ID:" + id + " No existe...");
  }
  Producto productoPorEditar = productoBuscado.get();

if ((datosEditados.getNombre() != null) || !datosEditados.getNombre().isBlank()){
  productoPorEditar.setNombre(datosEditados.getNombre());
}
  if (datosEditados.getPrecio() != null){
  productoPorEditar.setPrecio(datosEditados.getPrecio());
  }
    if (datosEditados.getStock() != null){
      productoPorEditar.setStock(datosEditados.getStock());
    }
    if (datosEditados.getAnioLanzamiento() != null){
      productoPorEditar.setAnioLanzamiento(datosEditados.getAnioLanzamiento());
    }


  return this.repository.guardaProducto(productoPorEditar);
  }

  @Override
  public Producto eliminarProducto(Long id) {
    Optional<Producto> productoBuscado = this.repository.buscarPorId(id);

    if(productoBuscado.isEmpty()){
      throw new RuntimeException("El producto con ID:" + id + " No existe...");
    }
    Producto productoEncontrado = productoBuscado.get();
    return this.repository.eliminarProducto(productoEncontrado);
  }
}
