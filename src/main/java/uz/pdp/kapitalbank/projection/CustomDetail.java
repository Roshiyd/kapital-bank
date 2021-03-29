package uz.pdp.kapitalbank.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.kapitalbank.entity.Detail;
import uz.pdp.kapitalbank.entity.Order;
import uz.pdp.kapitalbank.entity.Product;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Projection(types = Detail.class)
public interface CustomDetail {
    Integer getId();

    Order getOrder();

    Product getProduct();

    Integer getQuantity();
}
