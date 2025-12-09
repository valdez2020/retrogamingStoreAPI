package com.retrogaming.retrogamingAPI.controller;

import com.retrogaming.retrogamingAPI.entity.Producto;
import com.retrogaming.retrogamingAPI.service.ProductoDBService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class productoController {

  @Autowired
  private ProductoDBService service;

  @PostMapping
  public Producto crearProducto(@RequestBody Producto nuevoProducto){
    this.service.crearProducto(nuevoProducto);
    return nuevoProducto;
  }

  @GetMapping
  public List<Producto> mostrarProductos(){
    return this.service.mostrarProductos();
  }

  @GetMapping("/buscar")
  public List<Producto> filtrarProductos(@RequestParam(defaultValue = "",required = false) String nombre,
                                        @RequestParam(defaultValue = "0",required = false) Double precio){
return this.service.filtrarProductos(nombre,precio);
  }

  @PutMapping
  public Producto editarProducto(@RequestBody Producto productoEditado){
    return null;
  }

  @GetMapping("/buscar/{id}")
  public Producto buscarProductoPorId(@PathVariable Long id){
    return this.service.buscarProductoPorId(id);
  }

  @PutMapping("/{id}")
  public Producto editarProducto(@RequestBody Producto datosEditados,
                                 @PathVariable Long id){
    return this.service.editarProductoPorId(id,datosEditados);
  }

  @DeleteMapping("/{id}")
  public Producto eliminarProductoPorId(@PathVariable Long id){
    return this.service.eliminarProducto(id);
  }

}
