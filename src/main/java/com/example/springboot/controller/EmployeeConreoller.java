package com.example.springboot.controller;

import com.example.springboot.dao.DepartmentDao;
import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.entities.Department;
import com.example.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeConreoller {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    // 查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(ModelMap model){

        Collection<Employee> employees = employeeDao.getAll();
        // 放在请求域中
        model.addAttribute("emps",employees);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxx.html
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        // 来到添加页面
        return "emp/add";
    }
}
/*
1. 往请求域传参--》Model，Map，ModelMap 均可
 */
