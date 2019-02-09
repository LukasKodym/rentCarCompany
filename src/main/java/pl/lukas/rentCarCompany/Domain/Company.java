package pl.lukas.rentCarCompany.Domain;

import java.util.List;

public class Company {

    private String name;
    private String webDomain;
    private String address;
    private String owner;
    private String logo;
    private List<Department> department;

    public Company() {
    }

    public Company(String name, String webDomain, String address, String owner, String logo, List<Department> department) {
        this.name = name;
        this.webDomain = webDomain;
        this.address = address;
        this.owner = owner;
        this.logo = logo;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebDomain() {
        return webDomain;
    }

    public void setWebDomain(String webDomain) {
        this.webDomain = webDomain;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", webDomain='" + webDomain + '\'' +
                ", address='" + address + '\'' +
                ", owner='" + owner + '\'' +
                ", logo='" + logo + '\'' +
                ", department=" + department +
                '}';
    }
}
