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

    public Employee(String name, String lastName, boolean isManager, Department dept) {
        this.name = name;
        this.lastName = lastName;
        this.isManager = isManager;
        this.dept = dept;
    }
}
