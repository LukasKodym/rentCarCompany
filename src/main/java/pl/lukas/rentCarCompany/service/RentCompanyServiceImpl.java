package pl.lukas.rentCarCompany.service;

import pl.lukas.rentCarCompany.domain.*;

import java.util.List;
import java.util.Optional;
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

    public void addEmployeeWithParams(RentCompany newCompany, String firstName, String lastName, boolean isManager, String deptartamentAddress) {
        Optional<Department> department = findDepartmentByAddress(newCompany, deptartamentAddress);

        if(department.isPresent()) {
            Employee emp = new Employee(firstName, lastName, isManager, department.get());
            department.get().getEmployeeList().add(emp);
            System.out.println("Employee added");
        }
        else {
            System.out.println("Cannot add employee to departament that does not exist");
        }
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

    private Optional<Department> findDepartmentByAddress(RentCompany newCompany, String departmentAddress) {
        List<Department> departmentList = newCompany.getDepartment();
        return departmentList
                .stream()
                .filter(dep -> dep.getDeptAddress().equalsIgnoreCase(departmentAddress))
                .findFirst();
    }

    public void createCarForDepartment(RentCompanyServiceImpl rentCompanyService, RentCompany newCompany, String brand, String model, CarTypesEnum carTypesEnum, int productionYear, String color, int mileage, CarStatusEnum carStatusEnum, double costPerDay, String deptAddress) {
        Optional<Department> departmentByAddress = rentCompanyService.findDepartmentByAddress(newCompany, deptAddress);
        if (!departmentByAddress.isPresent()) {
            System.out.println("Departament does not exists");
        } else {
            Car car = new Car(brand, model, carTypesEnum,
                    productionYear, color, mileage,
                    carStatusEnum, costPerDay);
            departmentByAddress.ifPresent(p -> p.getCarList().add(car));
        }
    }
}
