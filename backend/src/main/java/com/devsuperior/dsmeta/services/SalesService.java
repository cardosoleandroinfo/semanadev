package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SalesService {

	@Autowired
	private SaleRepository repositorio;
	
	public List<Sale> findSales() {
		return repositorio.findAll();
	}
}
