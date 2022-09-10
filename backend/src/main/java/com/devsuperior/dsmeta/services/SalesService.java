package com.devsuperior.dsmeta.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SalesService {

	@Autowired
	private SaleRepository repositorio;
	
	public Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable) {
		return repositorio.findSales(min,max,pageable);
	}
	
	//public Page<Sale> findSales(Pageable pageable) {
		//return repositorio.findAll(pageable);
	//}
}
