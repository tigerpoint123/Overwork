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
    public Optional<ApplyRecord> updateStart(String date, String time) {
        Long id = em.createQuery("select m from ApplyRecord m where m.date =: nowDate", ApplyRecord.class)
                .setParameter("nowDate", date).getResultList().stream().findFirst().get().getId();
        ApplyRecord applyRecord = em.find(ApplyRecord.class, id);
        applyRecord.setStart(true);
        applyRecord.setStartTime(time);
        applyRecord.setDone("진행중");

        return Optional.of(applyRecord);
    }

    @Override
    public boolean startOrNot(String date) {
        boolean son = em.createQuery("select m from ApplyRecord m where m.date =: nowDate", ApplyRecord.class)
                .setParameter("nowDate", date).getResultList().stream().findFirst().get().isStart();
        return son;
    }

    @Override
    public Optional<ApplyRecord> updateEnd(String nowDate, String nowTime) {
        Long id = em.createQuery("select m from ApplyRecord m where m.date =: nowDate and m.start = true", ApplyRecord.class)
                .setParameter("nowDate", nowDate).getResultList().stream().findFirst().get().getId();
        ApplyRecord applyRecord = em.find(ApplyRecord.class, id);
        applyRecord.setEndTime(nowTime);
        applyRecord.setDone("진행완료");

        return Optional.empty();
    }
}
