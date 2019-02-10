package pl.lukas.rentCarCompany.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Consumer {

    private String name;
    private String lastName;
    private String email;
    private String address;

    public Consumer(String name, String lastName, String email, String address) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }
}
