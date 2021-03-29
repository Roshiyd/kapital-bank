package uz.pdp.kapitalbank.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.kapitalbank.entity.Attachment;
import uz.pdp.kapitalbank.entity.Category;
import uz.pdp.kapitalbank.entity.Product;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();

    String getName();

    Category getCategory();

    String getDescription();

    Double getPrice();

    Attachment getPhoto();
}
