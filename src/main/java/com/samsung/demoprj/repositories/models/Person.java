package com.samsung.demoprj.repositories.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Person {
    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}
