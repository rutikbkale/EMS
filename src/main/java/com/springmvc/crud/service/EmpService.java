package com.springmvc.crud.service;

import com.springmvc.crud.entity.Employee;
import com.springmvc.crud.repository.EmpRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired
    private EmpRepo repo;

    public boolean addEmp(Employee emp) {
        boolean flag = false;
        try {
            flag = repo.addEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Employee> showEmp() {
        List<Employee> list = new ArrayList<>();
        list = repo.showEmp();
        return list;
    }

    public Employee getEmp(int empId) {
        Employee emp = repo.getEmp(empId);
        return emp;
    }

    public boolean editEmp(Employee emp) {
        boolean flag = false;
        try {
            flag = repo.editEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteEmp(int empId) {
        boolean flag = false;
        try {
            flag = repo.deleteEmp(empId);
        } catch (Exception e) {
        }
        return flag;
    }

}
