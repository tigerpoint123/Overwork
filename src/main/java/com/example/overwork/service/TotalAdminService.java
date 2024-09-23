package com.example.overwork.service;

import com.example.overwork.entiry.TotalAdmin;
import com.example.overwork.repository.ApplyRepository;
import com.example.overwork.repository.TotalAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TotalAdminService {
    @Autowired
    private final TotalAdminRepository totalAdminRepository;

    public TotalAdminService(TotalAdminRepository totalAdminRepository) {
        this.totalAdminRepository = totalAdminRepository;
    }

    public Long totalInfoAdd(TotalAdmin totalAdmin) {
        totalAdminRepository.totalAdminAdd(totalAdmin);
        return totalAdmin.getId();
    }

    public List<TotalAdmin> findAll() {
        return totalAdminRepository.findAll();
    }
}
