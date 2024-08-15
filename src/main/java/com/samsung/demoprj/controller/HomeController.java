package com.samsung.demoprj.controller;

import com.samsung.demoprj.repositories.models.Person;
import com.samsung.demoprj.services.IPersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
    public String SavePerson(@ModelAttribute Person person,
                             @RequestParam("avatarupload") MultipartFile file)
    {
        if(person.id==null) {
            //Upload file process
            if(!file.isEmpty())
            {
                String folder = "D:\\gitdemo\\Spring\\demoprj\\src\\main\\resources\\static\\Pictures";
                Path folderPath = Paths.get(folder);

                try(InputStream inputStream = file.getInputStream())
                {
                    Path filePath = folderPath.resolve(file.getOriginalFilename());
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            person.id = lstPerson.size() +1;
            person.avatar = "/Pictures/" +file.getOriginalFilename();
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
