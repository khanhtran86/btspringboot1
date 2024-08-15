package com.samsung.demoprj.controller;

import com.samsung.demoprj.repositories.models.Person;
import com.samsung.demoprj.services.IPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {
    private static List<Person> lstPerson;
    IPersonService personService;
    public HomeController(IPersonService personService)
    {
        this.personService =personService;

        if(lstPerson==null)
            lstPerson = this.personService.getListOfPerson();
    }

    @GetMapping("/")
    public String Index(final Model model)
    {
        model.addAttribute("Persons", lstPerson);
        return "Index";
    }

    @GetMapping("/NewPerson")
    public String NewPerson(final Model model)
    {
        model.addAttribute("Person", Person.builder().build());
        return "NewPerson";
    }

    @PostMapping("/AddPerson")
    public String AddPerson(@ModelAttribute Person person)
    {
        lstPerson.add(person);
        return "redirect:/";
    }

}
