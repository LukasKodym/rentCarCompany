package pl.lukas.rentCarCompany.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Department {

    private String deptAddress;
    private List<Employee> employeeList;
    private List<Car> carList;

    public Department(String deptAddress) {
        this.deptAddress = deptAddress;
        this.employeeList = new ArrayList<>();
        this.carList = new ArrayList<>();
    }

}
