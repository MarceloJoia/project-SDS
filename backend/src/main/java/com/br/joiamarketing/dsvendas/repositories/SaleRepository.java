package com.br.joiamarketing.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.joiamarketing.dsvendas.dto.SaleSuccessDTO;
import com.br.joiamarketing.dsvendas.dto.SaleSumDTO;
import com.br.joiamarketing.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.br.joiamarketing.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGrupedBySeller();
	
	@Query("SELECT new com.br.joiamarketing.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGrupedBySeller();
}
