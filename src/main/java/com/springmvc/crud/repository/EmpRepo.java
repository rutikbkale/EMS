package com.springmvc.crud.repository;

import com.springmvc.crud.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmpRepo {

    @Autowired
    private HibernateTemplate template;

    @Transactional
    public boolean addEmp(Employee emp) {
        boolean flag = false;
        try {
            template.save(emp);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Employee getEmp(int empId) {
        Employee emp = template.get(Employee.class, empId);
        return emp;
    }

    public List<Employee> showEmp() {
        List<Employee> list = new ArrayList<>();
        list = template.loadAll(Employee.class);
        return list;
    }

    @Transactional
    public boolean editEmp(Employee emp) {
        boolean flag = false;
        try {
            template.update(emp);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Transactional
    public boolean deleteEmp(int empId) {
        boolean flag = false;
        try {
            Employee emp = template.get(Employee.class, empId);
            template.delete(emp);
            flag = true;
        } catch (Exception e) {
        }
        return flag;
    }

}
