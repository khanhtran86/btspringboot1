package com.samsung.demoprj.repositories.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ListPerson {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Person> data;
}
