package com.examen.truper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.truper.entity.Producto;
import com.examen.truper.service.ProductoService;

@RestController
@RequestMapping(value = "/api")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PutMapping(value = "/update")
	public ResponseEntity<Producto> updateProducto(@RequestParam(name = "producto") Producto producto) {
		Producto productoDb = productoService.updateProducto(producto);
		return ResponseEntity.ok(productoDb);
	}
}
