package com.example.kadry2.controller;


import com.example.kadry2.model.Employee;
import com.example.kadry2.model.EmployeeDTO;
import com.example.kadry2.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class EmployeeController {

    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //tworzymy gotowca, gdzie uzytkownik bedzie podawal dane
    @GetMapping("/employee-add")
    public String getForm(Model model) {
        // Model model - sluzy od zbierania danych - do nasteonych danych
        EmployeeDTO form = new EmployeeDTO();
        model.addAttribute("form", form);

        return "employee-add";
    }

    @PostMapping("/employee-add")
    public String addEmployee(@ModelAttribute("form") EmployeeDTO form) {
        Employee employee = new Employee();
        employee.setFirstname(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setAge(form.getAge());

        service.addEmployee(employee);

        // gdybysmy zostawili return na eployee-added to pozostalibysmy na ndopincie
        // każde oswieżenie strony skutkowałoby dodaniem tego samego do bazy danych
        // musimy w zwiazaku z tym przekierowac na inny endopoint np. employee-added
        return "redirect:/employee-added";
    }


    @ResponseBody // gdy dodamy ta danotaje to zamiast adnotacjae to wyswietli sie po prostu napis.
    @GetMapping("/employee-added")
    public String employeeAdded() {
        return "employee-added";
    }


    @ResponseBody
    @GetMapping("/employess")
    public List<Employee> getEmployess(@RequestParam(defaultValue = "brak") String imie,
                                       @RequestParam(defaultValue = "brak") String nazwisko) {

        if (imie.equals("brak") && nazwisko.equals("brak"))
            return service.findAll();
        else {
            return service.findByFirstAndLastName(imie, nazwisko);
        }
    }

//    @GetMapping(/)
//    public List<Employee> findByFirstAndLastName (@PathVariable String imie,
//                                                  @PathVariable String nazwisko){
//        return service.findByFirstAndLastName(imie, nazwisko);
//    }

    // zmacznik po konrutkorze - odpoali sie po kontrolerze
    //@PostConstruct
    public void addEmployeeOnStartup() {
        Employee employee = new Employee("Emil", "Gajęcki", 27);
        service.addEmployee(employee);
    }
}
