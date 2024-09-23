package com.example.overwork.repository;

import com.example.overwork.entiry.TotalAdmin;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaTotalAdminRepository implements TotalAdminRepository {
    private final EntityManager em;

    public JpaTotalAdminRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<TotalAdmin> totalAdminAdd(TotalAdmin totalAdmin) {
        em.persist(totalAdmin);
        return List.of();
    }

    @Override
    public List<TotalAdmin> findAll() {
        return em.createQuery("select t from TotalAdmin t", TotalAdmin.class).getResultList();
    }
}
