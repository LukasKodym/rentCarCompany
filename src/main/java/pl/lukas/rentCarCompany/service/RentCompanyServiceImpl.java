package pl.lukas.rentCarCompany.service;

import pl.lukas.rentCarCompany.domain.Department;
import pl.lukas.rentCarCompany.domain.RentCompany;

import java.util.List;

public class RentCompanyServiceImpl implements RentCompanyService {


    @Override
    public RentCompany createNewCompany(String name, String webDomain, String address, String owner, String logo) {
        return new RentCompany(name,webDomain,address,owner,logo);
    }

    @Override
    public RentCompany addDepartmentToCompany() {


        return null;
    }

    @Override
    public RentCompany removeDepartmentToCompany() {
        return null;
    }
}
