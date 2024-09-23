package com.example.overwork.repository;

import com.example.overwork.entiry.TotalAdmin;

import java.util.List;

public interface TotalAdminRepository {
    List<TotalAdmin> totalAdminAdd(TotalAdmin totalAdmin);

    List<TotalAdmin> findAll();
}
