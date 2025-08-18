package com.example.mcpserver.repository;

import com.example.mcpserver.model.MerchantPaymentAdvice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantPaymentAdviceRepository extends JpaRepository<MerchantPaymentAdvice, Long> {
}
