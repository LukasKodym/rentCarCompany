package pl.lukas.rentCarCompany.service;

import pl.lukas.rentCarCompany.domain.Department;
import pl.lukas.rentCarCompany.domain.RentCompany;

import java.util.List;

public interface RentCompanyService {

    RentCompany createNewCompany(String name, String webDomain, String address, String owner,
                                 String logo);

    RentCompany handleDepartmentsFromCompany(RentCompany newCompany, String userChoice, String address);
}
