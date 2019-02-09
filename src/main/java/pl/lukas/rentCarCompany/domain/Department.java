package pl.lukas.rentCarCompany.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Department {

    private String deptAddress;
    private List<Employee> employeeList;
    private List<Car> car;

}
