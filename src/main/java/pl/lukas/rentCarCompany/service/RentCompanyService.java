package pl.lukas.rentCarCompany.service;

import pl.lukas.rentCarCompany.domain.CarStatusEnum;
import pl.lukas.rentCarCompany.domain.CarTypesEnum;
import pl.lukas.rentCarCompany.domain.RentCompany;

public interface RentCompanyService {

    RentCompany createNewCompany(String name, String webDomain, String address, String owner,
                                 String logo);
    RentCompany handleDepartmentsFromCompany(RentCompany newCompany, String userChoice, String address);
    void addEmployeeWithParams(RentCompany newCompany, String firstName, String lastName,
                               boolean isManager, String departmentAddress);
    void createCarForDepartment(RentCompanyServiceImpl rentCompanyService, RentCompany newCompany,
                                String brand, String model, CarTypesEnum carTypesEnum,
                                int productionYear, String color, int mileage, CarStatusEnum carStatusEnum,
                                double costPerDay, String deptAddress);

}
