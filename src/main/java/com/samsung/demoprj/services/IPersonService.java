package com.samsung.demoprj.services;

import com.samsung.demoprj.repositories.models.Person;

import java.util.List;

public interface IPersonService {
    public List<Person> getListOfPerson();
}
