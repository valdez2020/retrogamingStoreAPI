package com.retrogaming.retrogamingAPI.repository;

import com.retrogaming.retrogamingAPI.entity.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ProductoDBRepository")
public class ProductoDBRepository implements ProductoRepository{

  @Autowired
  ProductoRepositoryJPA repositoryJPA;

  @Override
  public Producto guardaProducto(Producto nuevoProducto) {
    return this.repositoryJPA.save(nuevoProducto);
  }

  @Override
  public Producto eliminarProducto(Producto productoEliminado){
  this.repositoryJPA.delete(productoEliminado);
  return productoEliminado;
  }

@Override
  public   List<Producto> ListaProductos(){
    return this.repositoryJPA.findAll();
}
@Override
  public Optional<Producto> buscarPorId(Long id){
    return this.repositoryJPA.findById(id);
}

  @Override
 public  List<Producto> buscarProductosPorNombre(String nombre){
    return this.repositoryJPA.findByNombreContaining(nombre);
  }

  @Override
  public List<Producto> buscarProductosPorPecio(Double precio){
    return this.repositoryJPA.findByPrecioLessThanEqual(precio);
  }

  @Override
  public List<Producto> buscarProductosPorNombreYPrecios(String nombre, Double precio){

    return this.repositoryJPA.findByNombreContainingAndPrecioLessThanEqual(nombre, precio);
  }

  }

