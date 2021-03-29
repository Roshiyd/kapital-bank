package uz.pdp.kapitalbank.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.kapitalbank.entity.Customer;
import uz.pdp.kapitalbank.entity.Order;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Projection(types = Order.class)
public interface CustomOrder {
    Integer getId();

    Date getDate();

    Customer getCustomer();
}
