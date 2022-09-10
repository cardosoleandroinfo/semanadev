package com.devsuperior.dsmeta.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SalesService;


@RestController
@RequestMapping(value="/sales")
public class SaleController {

	@Autowired
	private SalesService servico;
	
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value="minDate",defaultValue = "") String minDate, 
			@RequestParam(value="maxDate",defaultValue = "")String maxDate,
			Pageable pageable)
	{
		LocalDate today = LocalDate.ofInstant(Instant.now(),ZoneId.systemDefault());
		
		LocalDate min=(maxDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate)) ;
		LocalDate max=(maxDate.equals("") ? today : LocalDate.parse(maxDate)) ;
		
		return servico.findSales(min,max,pageable);

	}
	//public Page<Sale> findSales(Pageable pageable)
	//{
		//return servico.findSales(pageable);

	//}
}
