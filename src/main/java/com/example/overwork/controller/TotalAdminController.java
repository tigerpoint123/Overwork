package com.example.overwork.controller;

import com.example.overwork.entiry.TotalAdmin;
import com.example.overwork.service.TotalAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TotalAdminController {
    private final TotalAdminService totalAdminService;

    public TotalAdminController(TotalAdminService totalAdminService) {
        this.totalAdminService = totalAdminService;
    }

    @GetMapping("/totalAdmin/totalAdminMain")
    public String totalAdmin(Model model) {
        List<TotalAdmin> list = totalAdminService.findAll();
        model.addAttribute("lists", list);

        return "totalAdmin/totalAdminMain";
    }

    @GetMapping("/totalInfoAddForm")
    public String addForm() {
        return "totalInfoAddForm";
    }

    @PostMapping("/totalInfoAdd")
    public String add(@RequestParam String name, @RequestParam int age, @RequestParam String gender,
                      @RequestParam String phoneNum, @RequestParam String email, @RequestParam String job,
                      @RequestParam int carrer, @RequestParam String department, TotalAdmin totalAdmin) {
        totalAdmin.setName(name);
        totalAdmin.setAge(age);
        totalAdmin.setGender(gender);
        totalAdmin.setPhone(phoneNum);
        totalAdmin.setEmail(email);
        totalAdmin.setJob(job);
        totalAdmin.setCarrer(carrer);
        totalAdmin.setDepartment(department);

        Long id =  totalAdminService.totalInfoAdd(totalAdmin);

        return "totalAdmin/totalAdminMain";
    }

    @GetMapping("/personalDetail")
    public String personalDetail(Model model) {

        return "totalAdmin/personalDetail";
    }

}
