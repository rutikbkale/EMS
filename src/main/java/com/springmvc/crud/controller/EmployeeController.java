package com.springmvc.crud.controller;

import com.springmvc.crud.entity.Employee;
import com.springmvc.crud.service.EmpService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @Autowired
    private EmpService service;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/home")
    public String home1() {
        return "index";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee() {
        return "addEmployees";
    }

    @RequestMapping("/addEmp")
    public String addEmp(@ModelAttribute Employee emp, HttpSession session) {
        boolean flag = service.addEmp(emp);
        if (flag) {
            session.setAttribute("msg", "Employee Added Successfully");
        } else {
            session.setAttribute("msg", "Error occur !");
        }
        return "redirect:addEmployee";
    }

    @RequestMapping("/showEmp")
    public String showEmp(Model model) {
        List<Employee> list = service.showEmp();
        model.addAttribute("empList", list);
        return "showEmp";
    }

    @RequestMapping("/editEmp")
    public String editEmp(@RequestParam int id, Model model) {
        Employee emp = service.getEmp(id);
        model.addAttribute("emp", emp);
        return "editEmpForm";
    }

    @RequestMapping("/editEmpDetails")
    public String editEmpDetails(@ModelAttribute Employee emp, HttpSession session) {
        boolean flag = service.editEmp(emp);
        if (flag) {
            session.setAttribute("msg", "Employee Edited Successfully");
        } else {
            session.setAttribute("msg", "Error occur !");
        }
        return "redirect:showEmp";
    }

    @RequestMapping("deleteEmp")
    public String deleteEmp(@RequestParam int id, HttpSession session) {
        boolean flag = service.deleteEmp(id);
        if (flag) {
            session.setAttribute("msg", "Employee Deleted Successfully");
        } else {
            session.setAttribute("msg", "Error occur !");
        }
        return "redirect:showEmp";
    }

}
