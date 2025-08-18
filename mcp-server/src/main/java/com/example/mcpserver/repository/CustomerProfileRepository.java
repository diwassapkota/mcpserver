package com.example.mcpserver.repository;

import com.example.mcpserver.model.CustomerProfile;
import com.example.mcpserver.model.CustomerProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, CustomerProfileId> {
}
