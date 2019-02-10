package pl.lukas.rentCarCompany.service;

import pl.lukas.rentCarCompany.domain.Department;
import pl.lukas.rentCarCompany.domain.RentCompany;

import java.util.List;
import java.util.stream.Collectors;

public class RentCompanyServiceImpl implements RentCompanyService {


    @Override
    public RentCompany createNewCompany(String name, String webDomain, String address, String owner, String logo) {
        return new RentCompany(name, webDomain, address, owner, logo);
    }

    @Override
    public RentCompany handleDepartmentsFromCompany(RentCompany newCompany, String userChoice, String address) {
        if (userChoice.equalsIgnoreCase("1")) {
            addDepartmentToCompany(newCompany, address);
        } else if (userChoice.equalsIgnoreCase("2")) {
            removeDepartmentToCompany(newCompany, address);
        } else {
            System.out.println("Wrong option, try again");
        }
        return newCompany;
    }

    private static boolean checkIfDepartmentExists(String address, List<Department> departmentList) {
        int size = departmentList
                .stream()
                .filter(d -> d.getDeptAddress().equalsIgnoreCase(address))
                .collect(Collectors.toList()).size();

        return size > 0;
    }

    public void addDepartmentToCompany(RentCompany newCompany, String address) {
        if (!checkIfDepartmentExists(address, newCompany.getDepartment())) {
            Department department = new Department(address);
            newCompany.getDepartment().add(department);
        }
    }

    public void removeDepartmentToCompany(RentCompany newCompany, String address) {
        if (checkIfDepartmentExists(address, newCompany.getDepartment())) {
            List<Department> departmentList = newCompany.getDepartment();
            for (Department d : departmentList) {
                if (d.getDeptAddress().equalsIgnoreCase(address)) {
                    departmentList.remove(d);
                    break;
                }
            }
        }
    }
}
