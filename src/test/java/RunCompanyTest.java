
import org.junit.Test;
import pl.lukas.rentCarCompany.domain.RentCompany;
import pl.lukas.rentCarCompany.service.RentCompanyService;
import pl.lukas.rentCarCompany.service.RentCompanyServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class RunCompanyTest {


    @Test
    public void shouldTestExample()  {
        //given
        //warunki poczatkowe
        RentCompanyService rentCompanyService =  new RentCompanyServiceImpl();
        String name = "Name";
        String website = "website";
        String address = "address";
        String owner = "owner";
        String logo = "logo";
        //when
        //akcja
        RentCompany newCompany = rentCompanyService.createNewCompany(name, website, address, owner, logo);

        //then
       //assercje
        assertThat(newCompany.getName()).isEqualToIgnoringCase("name");
        assertThat(newCompany.getDepartments()).isNotNull();

    }



}
