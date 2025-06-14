package com.luv2code.springboot.thymeleafdemo.controller;


import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }
    @GetMapping("/list")
    public String ListEmployees(Model theModel) {
        //get the employees from DB
        List<Employee>theEmployees=employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees",theEmployees);

        return "employees/list-employees";
    }
@GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
      Employee theEmployee=new Employee();
      theModel.addAttribute("employee",theEmployee);
      return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(
            @Valid @ModelAttribute("employee") Employee theEmployee,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "employees/employee-form";
        }

        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }


    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId")int theEmployeeId){
        employeeService.deleteById(theEmployeeId);
        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId")int theEmployeeId,Model theModel){
        Employee theEmployee=employeeService.findById(theEmployeeId);
        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }
@DeleteMapping("/deleteAll")
    public String deleteAll(){
        employeeService.deleteAll();
        return "redirect:/employees/list";
    }


}
