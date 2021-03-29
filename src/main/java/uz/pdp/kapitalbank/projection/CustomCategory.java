package uz.pdp.kapitalbank.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.kapitalbank.entity.Category;

@Projection(types = Category.class)
public interface CustomCategory {

    Integer getId();

    String getName();
}
