package com.example.overwork.test;

import com.example.overwork.entiry.ApplyRecord;
import com.example.overwork.entiry.Grade;
import com.example.overwork.entiry.Member;
import com.example.overwork.service.ApplyService;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional // 쿼리 업데이트. 허나 rollback의 성질이 있으므로 commit을 써서 저장된 데이터를 볼 수 있다.
class OverworkTest {

//    @BeforeEach
    void 관리자만들기() {
        Member member = new Member();
        //given
        member.setUsername("admin");
        member.setPassword("admin");
        member.setGrade(Grade.ADMIN);

        //when
        Long id = memberService.join(member);
    }

//    @BeforeEach
    void 사용자만들기() {
        Member member = new Member();
        //given
        member.setUsername("user");
        member.setPassword("user");
        member.setGrade(Grade.USER);

        //when
        Long id = memberService.join(member);
    }

    @Autowired
    MemberService memberService;
    @Autowired
    LoginService loginService;
    @Autowired
    ApplyService applyService;

    @Test
//    @Commit // 테스트 끝나고 데이터를 지우지 않는 것
    public void 회원가입하기() {
        Member member = new Member();

        //given
        member.setUsername("user");
        member.setPassword("user");
        member.setGrade(Grade.USER);

        //when
        Long id = memberService.join(member);

        //then
        Member findMember = memberService.findOne(id).get();
        assertThat(member.getUsername()).isEqualTo(findMember.getUsername());
    }

    @Test
    void 로그인하기() {
        Member member = new Member();

        //given
        member.setUsername("user2");
        member.setPassword("user");
        member.setGrade(Grade.USER);

        //when
        assertThat(member.checkLogin(member.getUsername(), member.getPassword()));


        //then
    }

    @Test
//    @Commit
    void 초과근무신청하기() {
        //given
        Member member = new Member();
        ApplyRecord applyRecord = new ApplyRecord();
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = date.format(new Date());
        DateFormat time = new SimpleDateFormat("HH:mm");
        String nowTime = time.format(new Date());

        //when
        applyRecord.setUsername("user");
        applyRecord.setDate(nowDate);
        applyRecord.setTime(nowTime);
        applyRecord.setContent("면담기록소급");
        applyRecord.setStart(false);
        Long id = applyService.makeRecord(applyRecord);

        //then
    }

    @Test
//    @Commit
    void 초과근무시작하기() {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = date.format(new Date());
        DateFormat time = new SimpleDateFormat("HH:mm");
        String nowTime = time.format(new Date());

        applyService.updateStart(nowDate, nowTime);
    }
}
