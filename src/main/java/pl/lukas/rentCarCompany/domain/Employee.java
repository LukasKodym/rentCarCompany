package pl.lukas.rentCarCompany.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private String name;
    private String lastName;
    private boolean isManager;
    private Department dept;



}
