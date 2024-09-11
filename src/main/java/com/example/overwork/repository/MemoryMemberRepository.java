package com.example.overwork.repository;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.entiry.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String username) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public ApplyRecord recordApplyment(ApplyRecord applyRecord) {
        return null;
    }

//    private static Map<Long, Member> store = new HashMap<>();
//    private static long sequence = 0L;
//
//    @Override
//    public Member save(Member member) {
//        member.setId(++sequence);
//        store.put(member.getId(), member);
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        return Optional.ofNullable(store.get(id));
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        return store.values().stream().filter(member -> member.getUsername().equals(name)).findAny();
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return new ArrayList<>(store.values());
//    }
}
