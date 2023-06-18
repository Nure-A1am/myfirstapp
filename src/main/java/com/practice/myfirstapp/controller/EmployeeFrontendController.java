package com.practice.myfirstapp.controller;

import com.practice.myfirstapp.model.Employee;
import com.practice.myfirstapp.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.practice.myfirstapp.configuration.AppConfigConstants.*;


@Controller
public class EmployeeFrontendController {

    @Autowired
    private EmployeeRepository employeeRepository;

     public PasswordEncoder passwordEncoder;

    @Autowired
    public void EmployeeRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(ADD_EMPLOYEE_FORM_URL)
    public String showAddEmployeeForm(Employee employee) {
        return "create_new_employee";
    }

    @GetMapping(WELCOME_PAGE_URL)
    public String showWecomePage() {
        return "welcome";
    }

    @GetMapping(ACCESS_DENIED_PAGE_URL)
    public String showAccessDeniedPage() {
        return "accessDeniedPage";
    }


    @PostMapping(ADD_EMPLOYEE_PROCESS_URL)
    public String addEmp(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create_new_employee";
        }
        String rawPassword = employee.getPassword();
        // Encode the password using the PasswordEncoder
        String encodedPassword = passwordEncoder.encode(rawPassword);
        employee.setPassword(encodedPassword);
        employeeRepository.save(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping(EMPLOYEE_LIST_URL)
    public String showEmployeeList(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("successMessage", redirectAttributes.getAttribute("successMessage"));
        model.addAttribute("employees", employeeRepository.findAll());
        return "employees";
    }


    @GetMapping(UPDATE_EMPLOYEE_FORM_URL)
    public String showUpdateForm(@PathVariable("id") long id, Model model, RedirectAttributes redirectAttributes) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping(UPDATE_EMPLOYEE_PROCESS_URL)
    public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee,
                                 BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            employee.setId(id);
            System.out.println("Update Error: " + result.hasErrors());
            return "edit_employee";
        }
        String rawPassword = employee.getPassword();
        // Encode the password using the PasswordEncoder
        String encodedPassword = passwordEncoder.encode(rawPassword);
        employee.setPassword(encodedPassword);
        employeeRepository.save(employee);
        redirectAttributes.addFlashAttribute("successMessage", "Employee updated successfully");
        return "redirect:/employee/list";
    }

    @GetMapping(DELETE_EMPLOYEE_PROCESS_URL)
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        employeeRepository.delete(employee);
        return "redirect:/employee/list";
    }
}
