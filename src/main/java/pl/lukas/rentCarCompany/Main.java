package pl.lukas.rentCarCompany;

import pl.lukas.rentCarCompany.domain.*;
import pl.lukas.rentCarCompany.service.*;

import java.util.Scanner;

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
                    //logika tworzaca depertament

                } else {
                    System.out.println("First you need create company");
                }

            } else if (action.equalsIgnoreCase("3")) {

            }
        }
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
}
