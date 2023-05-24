package com.practice.myfirstapp.controller;

import com.practice.myfirstapp.model.Employee;
import com.practice.myfirstapp.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EmployeeFrontendController {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @RequestMapping("/new")
//    public ModelAndView showRegisterForm() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("create_new_employee");
//        return modelAndView;
//    }
    @GetMapping("employee/new")
    public String showRegisterForm(Employee employee) {
        return "create_new_employee";
    }

    @PostMapping("/addemp")
    public String addEmp(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create_new_employee";
        }
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String showEmployeeList(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employees";
    }

    @GetMapping("employee/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping("employee/update/{id}")
    public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            employee.setId(id);
            System.out.println(result.hasErrors());
            return "edit_employee";
        }

        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("employee/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        employeeRepository.delete(employee);
        return "redirect:/";
    }
}
