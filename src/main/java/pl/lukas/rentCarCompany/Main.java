package pl.lukas.rentCarCompany;

import pl.lukas.rentCarCompany.domain.*;
import pl.lukas.rentCarCompany.service.*;

import java.util.*;


public class Main {

    //zad5. tworzenie klienta
    //zad6. tworzenie samochodu
    //zad6b rozbudowanie aplikacji o zarzadzanie wieloma firmami
    //zad7. wypozyczenie samochodu...
    //zad8. wypozyczenie samochodu
    //wypozyczenie samochodu - utworzenie rezerwacji...
    //zwrot samochodu - aktualizacja kilometrow,
    //przypisanie samochodu do departamentu zwrotu oraz obliczenie kosztu calkowitego rezerwacji
    //zad9. zrzut stanu aplikacji do pliku txt (dla przecwiczenia zapisu do pliku)
    //zad10. zastapenie System.out.println przez loggera
    //zad11. dokananie refaktoryzacji kodu  interfejsy + klasy service
    //zad12. napisac testy jednostkowe o pokryciu 75%-80% +
    //zad13. dodanie bazy danych + jdbc/hibernate
    //zad14. zaimplementowanie rzeczy z pdf od zadania
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentCompanyService rentCompanyService = new RentCompanyServiceImpl();
        RentCompany currentCompany = null;
        List<RentCompany> companies = new ArrayList<>();
        showInstructions();

        String action = "";
        while (!action.equalsIgnoreCase("10")) {
            action = scanner.nextLine();
            if (action.equalsIgnoreCase("0")) {
                companies.forEach(company -> System.out.println(company.getName()));
                String chosenCompanyName = scanner.nextLine();
                currentCompany = null;
                for (RentCompany company : companies) {
                    if (company.getName().equalsIgnoreCase(chosenCompanyName)) {
                        currentCompany = company;
                        break;
                    }
                }
                if (currentCompany == null) {
                    System.out.println("Try again, company with name " +
                            "you gave does not exist");
                }

            } else if (action.equalsIgnoreCase("1")) {
                System.out.println("Creating new company");
                currentCompany = createCompany(scanner, rentCompanyService);
                System.out.println("New company created");

            } else if (action.equalsIgnoreCase("2")) {
                System.out.println("Creating new department");
                if (currentCompany != null) {
                    currentCompany = handleCompanyDepartments(scanner, rentCompanyService, currentCompany);
                    System.out.println("New department created");
                } else {
                    System.out.println("First you need create company");
                }

            } else if (action.equalsIgnoreCase("3")) {
                System.out.println("Display company status");
                System.out.println(currentCompany);
                System.out.println("Dispaly clients: ");
                currentCompany.getConsumers().forEach(System.out::println);

            } else if (action.equalsIgnoreCase("4")) {
                System.out.println("Creating employee with department ,pass firstName, lastName, manager, dept address");
                addNewEmployeeWithDepartment(scanner, currentCompany, rentCompanyService);

            } else if (action.equalsIgnoreCase("5")) {
                System.out.println("Creating client, pass firstName, lastName, email, address");
                addNewConsumer(currentCompany.getConsumers(), scanner);
                System.out.println("New client created");

            } else if (action.equalsIgnoreCase("6")) {
                System.out.println("Creating car");
                addNewCar(scanner, (RentCompanyServiceImpl) rentCompanyService, currentCompany);
                System.out.println("Car created");
            }
        }
    }

    private static void addNewCar(Scanner scanner, RentCompanyServiceImpl rentCompanyService, RentCompany newCompany) {
        String brand = scanner.nextLine();
        String model = scanner.nextLine();
        CarTypesEnum carTypesEnum = CarTypesEnum.valueOf(scanner.nextLine());
        int productionYear = Integer.parseInt(scanner.nextLine());
        String color = scanner.nextLine();
        int mileage = Integer.parseInt(scanner.nextLine());
        CarStatusEnum carStatusEnum = CarStatusEnum.valueOf(scanner.nextLine());
        double costPerDay = Double.parseDouble(scanner.nextLine());
        String deptAddress = scanner.nextLine();

        rentCompanyService.createCarForDepartment(rentCompanyService, newCompany, brand, model, carTypesEnum, productionYear, color, mileage, carStatusEnum, costPerDay, deptAddress);
    }


    private static void addNewConsumer(List<Consumer> clientList, Scanner scanner) {
        String name = scanner.nextLine();
        String lastName = scanner.nextLine();
        String email = scanner.nextLine();
        String address = scanner.nextLine();
        Consumer consumer = new Consumer(name, lastName, email, address);
        clientList.add(consumer);
    }

    public static void addNewEmployeeWithDepartment(Scanner scanner, RentCompany newCompany,
                                                    RentCompanyService rentCompanyService) {
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String isManagerString = scanner.nextLine();
        boolean isManager = isManagerString.equalsIgnoreCase("y");
        String departmentAddress = scanner.nextLine();
        rentCompanyService.addEmployeeWithParams(newCompany, firstName, lastName, isManager, departmentAddress);
    }

    private static RentCompany handleCompanyDepartments(Scanner scanner, RentCompanyService rentCompanyService,
                                                        RentCompany newCompany) {
        System.out.println("Do you want to create(1) or delete(2) department ");
        String userChoice = scanner.nextLine();
        System.out.println("Enter department address");
        String address = scanner.nextLine();
        newCompany = rentCompanyService.handleDepartmentsFromCompany(newCompany, userChoice, address);
        return newCompany;
    }

    private static void showInstructions() {
        System.out.println("How program works:");
        System.out.println("Option 1 to create new company - pass all needed info");
        System.out.println("Option 2 to create department for given company");
        System.out.println("Option 3 display company with departments");
        System.out.println("Option 4 add new worker to given department");
        System.out.println("Option 5 add new client");
        System.out.println("Option 6 add new car");
        System.out.println("Option 7 rent a car");
        System.out.println("Option 10 exit program");
    }

    private static RentCompany createCompany(Scanner scanner, RentCompanyService rentCompanyService) {
        System.out.println("Pass params");
        String name = scanner.nextLine();
        String website = scanner.nextLine();
        String address = scanner.nextLine();
        String owner = scanner.nextLine();
        String logo = scanner.nextLine();
        System.out.println("Passed all params");
        return rentCompanyService.createNewCompany(name, website,
                address, owner, logo);
    }
}
