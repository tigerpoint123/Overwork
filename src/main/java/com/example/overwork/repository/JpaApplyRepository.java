package com.example.overwork.repository;

import com.example.overwork.entiry.ApplyRecord;
import jakarta.persistence.EntityManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JpaApplyRepository implements ApplyRepository {
    private final EntityManager em;

    public JpaApplyRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public ApplyRecord recordApplyment(ApplyRecord applyRecord) {
        em.persist(applyRecord);
        return applyRecord;
    }

    @Override
    public List<ApplyRecord> allRecordApplymentList() {
        return em.createQuery("select m from ApplyRecord m", ApplyRecord.class).getResultList();
    }

    @Override
    public List<ApplyRecord> findTodayApplymentList() {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        return em.createQuery("select m from ApplyRecord m where m.date = " + date.format(new Date()), ApplyRecord.class).getResultList();
    }

}
