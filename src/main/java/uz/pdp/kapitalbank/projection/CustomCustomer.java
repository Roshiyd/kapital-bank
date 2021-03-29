package uz.pdp.kapitalbank.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.kapitalbank.entity.Customer;

import javax.persistence.Column;

@Projection(types = Customer.class)
public interface CustomCustomer {
    Integer getId();

    String getName();

    String getCountry();

    String getAddress();

    String getPhone();
}
