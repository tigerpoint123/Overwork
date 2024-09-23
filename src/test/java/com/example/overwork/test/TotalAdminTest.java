package com.example.overwork.test;

import com.example.overwork.entiry.TotalAdmin;
import com.example.overwork.service.ApplyService;
import com.example.overwork.service.LoginService;
import com.example.overwork.service.TotalAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional // 쿼리 업데이트. 허나 rollback의 성질이 있으므로 commit을 써서 저장된 데이터를 볼 수 있다.
public class TotalAdminTest {
    @Autowired
    TotalAdminService totalAdminService; ;
    @Autowired
    LoginService loginService;
    @Autowired
    ApplyService applyService;

    @Test
    @Commit
    void 연통정보넣기() {
        TotalAdmin totalAdmin = new TotalAdmin();
        totalAdmin.setName("오경록");
        totalAdmin.setAge(29);
        totalAdmin.setGender("남");
        totalAdmin.setPhone("010-1234-5678");
        totalAdmin.setEmail("email");
        totalAdmin.setJob("job");
        totalAdmin.setCarrer(2);
        totalAdmin.setDepartment("department");
        Long id = totalAdminService.totalInfoAdd(totalAdmin);

        System.out.println(id);
    }
}
