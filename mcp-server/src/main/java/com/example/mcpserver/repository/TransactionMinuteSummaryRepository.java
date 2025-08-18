package com.example.mcpserver.repository;

import com.example.mcpserver.model.TransactionMinuteSummary;
import com.example.mcpserver.model.TransactionMinuteSummaryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMinuteSummaryRepository extends JpaRepository<TransactionMinuteSummary, TransactionMinuteSummaryId> {
}
