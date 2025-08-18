package com.example.mcpserver.repository;

import com.example.mcpserver.model.MerchantProfile;
import com.example.mcpserver.model.MerchantProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantProfileRepository extends JpaRepository<MerchantProfile, MerchantProfileId> {
}
