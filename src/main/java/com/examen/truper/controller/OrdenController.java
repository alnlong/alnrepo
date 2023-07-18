package com.examen.truper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.truper.entity.Orden;
import com.examen.truper.service.OrdenService;

@RestController
@RequestMapping(value = "/api")
public class OrdenController {
	
	@Autowired
	private OrdenService ordenService;

	@PostMapping(value = "/ordenes")
	public ResponseEntity<Orden> createOrden(@RequestBody Orden orden) {
		Orden ordenCreated = ordenService.createOrden(orden);
		return ResponseEntity.ok(ordenCreated);
	}
	
	@GetMapping(value = "/ordenes/{idOrden}")
	public ResponseEntity<Orden> getOrden(@PathVariable(name = "idOrden") Integer idOrden) {
		Orden orden = new Orden();
		orden.setIdOrden(idOrden);
		Orden ordenDb = ordenService.getOrden(orden);
		return ResponseEntity.ok(ordenDb);
	}
}
