package com.samsung.demoprj.controller;

import com.samsung.demoprj.repositories.models.Person;
import com.samsung.demoprj.services.IPersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "PersonInfo";
    }

    @PostMapping("/SavePerson")
    public String SavePerson(@ModelAttribute Person person)
    {
        if(person.id==null) {
            person.id = lstPerson.size() +1;
            lstPerson.add(person);
        }
        else
        {
            Person updatePerson = lstPerson.stream().filter((p)->p.id== person.getId()).findFirst().get();
            updatePerson.first_name = person.first_name;
            updatePerson.last_name = person.last_name;
            updatePerson.email = person.email;
            updatePerson.avatar = person.avatar;
        }
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String EditPerson(@PathVariable("id")Integer id, final Model model)
    {
        Person person = lstPerson.stream().filter((p)->p.id==id).findFirst().get();
        model.addAttribute("Person", person);
        return "PersonInfo";
    }

    @GetMapping("delete/{id}")
    public String DeletePerson(@PathVariable("id")Integer id)
    {
        Person person = lstPerson.stream().filter((p)->p.id==id).findFirst().get();
        lstPerson.remove(person);

        return "redirect:/";
    }

}
