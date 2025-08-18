package com.example.mcpserver.service;

import com.example.mcpserver.model.CustomerProfile;
import com.example.mcpserver.model.MerchantPaymentAdvice;
import com.example.mcpserver.model.MerchantProfile;
import com.example.mcpserver.model.TransactionMinuteSummary;
import com.example.mcpserver.repository.CustomerProfileRepository;
import com.example.mcpserver.repository.MerchantPaymentAdviceRepository;
import com.example.mcpserver.repository.MerchantProfileRepository;
import com.example.mcpserver.repository.TransactionMinuteSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class McpService {

    @Autowired
    private MerchantPaymentAdviceRepository merchantPaymentAdviceRepository;

    @Autowired
    private CustomerProfileRepository customerProfileRepository;

    @Autowired
    private MerchantProfileRepository merchantProfileRepository;

    @Autowired
    private TransactionMinuteSummaryRepository transactionMinuteSummaryRepository;

    public List<MerchantPaymentAdvice> getAllMerchantPaymentAdvices() {
        return merchantPaymentAdviceRepository.findAll();
    }

    public List<CustomerProfile> getAllCustomerProfiles() {
        return customerProfileRepository.findAll();
    }

    public List<MerchantProfile> getAllMerchantProfiles() {
        return merchantProfileRepository.findAll();
    }

    public List<TransactionMinuteSummary> getAllTransactionMinuteSummaries() {
        return transactionMinuteSummaryRepository.findAll();
    }
}
