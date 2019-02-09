package pl.lukas.rentCarCompany;

import pl.lukas.rentCarCompany.service.RentCompanyService;
import pl.lukas.rentCarCompany.service.RentCompanyServiceImpl;

public class Main {

    public static void main(String[] args) {


        RentCompanyService rentCompanyService = new RentCompanyServiceImpl();

        // adding rentcar company

        rentCompanyService.createNewCompany();

        // adding and removing departments

        rentCompanyService.addDepartmentToCompany();
        rentCompanyService.removeDepartmentToCompany();


    }


}
