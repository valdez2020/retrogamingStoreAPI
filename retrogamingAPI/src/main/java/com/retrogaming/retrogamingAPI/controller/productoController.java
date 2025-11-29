package com.retrogaming.retrogamingAPI.controller;

import com.retrogaming.retrogamingAPI.model.Producto;
import com.retrogaming.retrogamingAPI.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class productoController {

  @Autowired
  private ProductoService service;

  @PostMapping
  public Producto crearProducto(@RequestBody Producto nuevoProducto){
    this.service.crearProducto();
    return nuevoProducto;
  }
}
