package pl.lukas.rentCarCompany;

import pl.lukas.rentCarCompany.domain.*;
import pl.lukas.rentCarCompany.service.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        RentCompanyService rentCompanyService = new RentCompanyServiceImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu:");
        System.out.println("Option 1 to create new company - pass all needed info");
        System.out.println("Option 2 to create department for given company");
        System.out.println("Option 3 display company with departments");
        System.out.println("Option 4 exit program");

        RentCompany newCompany = null;
        String action = "";

        while (!action.equalsIgnoreCase("4")) {
            action = scanner.nextLine();
            if (action.equalsIgnoreCase("1")) newCompany = createCompany(scanner, rentCompanyService);

            else if (action.equalsIgnoreCase("2")) {
                if (newCompany != null) {
                    newCompany = handleCompanyDepartments(scanner, rentCompanyService, newCompany);
                } else {
                    System.out.println("First you need create company");
                }
            } else if (action.equalsIgnoreCase("3")) {
                System.out.println(newCompany);
            } else if (action.equalsIgnoreCase("4")) {
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                boolean isManager = scanner.nextBoolean();
                String departmentAddress = scanner.nextLine();

                findDepartmentByAddress(newCompany, departmentAddress);
            }
        }
    }

    private static void findDepartmentByAddress(RentCompany newCompany, String deptartamentAddress) {





    }

    private static RentCompany createCompany(Scanner scanner, RentCompanyService rentCompanyService) {
        System.out.print("Company name: ");
        String name = scanner.nextLine();
        System.out.print("\nWeb site: ");
        String website = scanner.nextLine();
        System.out.print("\nAddress: ");
        String address = scanner.nextLine();
        System.out.print("\nOwner name: ");
        String owner = scanner.nextLine();
        System.out.print("\nLogo: ");
        String logo = scanner.nextLine();

        return rentCompanyService.createNewCompany(name, website,
                address, owner, logo);
    }

    private static RentCompany handleCompanyDepartments(Scanner scanner, RentCompanyService
            rentCompanyService, RentCompany newCompany) {
        System.out.println("Do you want to create(1) or delete(2) departament ");
        String userChoice = scanner.nextLine();
        System.out.println("Enter departmens address");
        String address = scanner.nextLine();

        newCompany = rentCompanyService.handleDepartmentsFromCompany(newCompany, userChoice, address);
        return newCompany;
    }

    private static void showInstructions() {
        System.out.println("How program works:");
        System.out.println("Option 1 to create new company - pass all needed info");
        System.out.println("Option 2 to create department for given company");
        System.out.println("Option 3 display company with departments");
        System.out.println("Option 4 add new worker to given departament");
        System.out.println("Option 5 add new client");
        System.out.println("Option 6 add new car");
        System.out.println("Option 7 rent a car");
        System.out.println("Option 10 exit program");

    }
}
