package pl.lukas.rentCarCompany.Domain;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Return {

    private Employee employee;
    private LocalDate returnDate;
    private Reservation reservation;
    private String additionalInfo;
}
