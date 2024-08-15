package com.samsung.demoprj.controller;

import com.samsung.demoprj.repositories.models.Person;
import com.samsung.demoprj.services.IPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {
    IPersonService personService;
    public HomeController(IPersonService personService)
    {
        this.personService =personService;
    }

    @GetMapping("/")
    public String Index(final Model model)
    {
        List<Person> lstPerson = this.personService.getListOfPerson();

        model.addAttribute("Persons", lstPerson);
        return "Index";
    }

}
