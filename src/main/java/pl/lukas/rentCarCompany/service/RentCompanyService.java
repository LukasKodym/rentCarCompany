package pl.lukas.rentCarCompany.service;

import pl.lukas.rentCarCompany.domain.RentCompany;

public interface RentCompanyService {

    RentCompany createNewCompany();
    RentCompany addDepartmentToCompany();
    RentCompany removeDepartmentToCompany();
}
