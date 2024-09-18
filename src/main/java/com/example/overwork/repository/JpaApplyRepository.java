package com.example.overwork.repository;

import com.example.overwork.entiry.ApplyRecord;
import jakarta.persistence.EntityManager;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

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
    public List<ApplyRecord> findTodayApplymentList(String nowDate) {
        return em.createQuery("select m from ApplyRecord m where m.date =: nowDate", ApplyRecord.class)
                .setParameter("nowDate", nowDate).getResultList();
    }

    @Override
    public Optional<ApplyRecord> updateStart(@Param(value="date") String nowDate) {
        Long id = em.createQuery("select m from ApplyRecord m where m.date =: nowDate", ApplyRecord.class)
                .setParameter("nowDate", nowDate).getResultList().stream().findFirst().get().getId();
//        System.out.println(id);
        ApplyRecord applyRecord = em.find(ApplyRecord.class, id);
        applyRecord.setStart(true);

        return null;
    }
}
