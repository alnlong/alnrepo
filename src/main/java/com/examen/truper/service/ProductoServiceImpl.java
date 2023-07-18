package com.examen.truper.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.truper.entity.Producto;
import com.examen.truper.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Producto updateProducto(Producto producto) {
		Optional<Producto> productoDb = productoRepository.findById(producto.getIdProducto());
		Producto resp = null;
		if (productoDb.isPresent()) {
			Producto prodUpdate = productoDb.get();
			prodUpdate.setPrecio(producto.getPrecio());
			resp = productoRepository.save(producto);
		}
		
		return resp;
	}

}
