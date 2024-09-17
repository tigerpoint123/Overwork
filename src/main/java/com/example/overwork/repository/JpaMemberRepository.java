package com.example.overwork.repository;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.entiry.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return em.createQuery("select m from Member m where m.id =: id", Member.class).setParameter("id", id).getResultList().stream().findFirst();
    }

    @Override
    public Optional<Member> findByName(String username) {
        return em.createQuery("select m from Member m where m.username =: name", Member.class)
                .setParameter("name", username).getResultList().stream().findFirst();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList(); //JPQL
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
    public Optional<ApplyRecord> updateStart(String nowDate) {


//        ApplyRecord applyRecord = em.find(ApplyRecord.class, id);
//        applyRecord.setStart(true);
        return null;
    }

    @Override
    public TypedQuery<ApplyRecord> findId() {
        TypedQuery<ApplyRecord> query = em.createQuery("select m.id from ApplyRecord m", ApplyRecord.class);
        return query;
    }

    @Override
    public List<ApplyInfoMapping> letsFindId() {
        return List.of();
    }

}
