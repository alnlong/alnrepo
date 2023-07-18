package com.examen.truper.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.truper.entity.Orden;
import com.examen.truper.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService {
	
	@Autowired
	private OrdenRepository ordenRepository;

	@Override
	public Orden createOrden(Orden orden) {
		Optional<Orden> ordenDb = ordenRepository.findById(orden.getIdOrden());
		if (ordenDb.isPresent()) {
			return orden;
		}
		return ordenRepository.save(orden);
	}

	@Override
	public Orden getOrden(Orden orden) {
		Optional<Orden> ordenDb = ordenRepository.findById(orden.getIdOrden());
		return ordenDb.get();
	}

}
