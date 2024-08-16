package com.samsung.demoprj.repositories.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Getter
@Setter
public class Student {
    public String Name;
    public String Email;
    public LocalDate Birthday;
    public long Salary;
    public String Description;
}
