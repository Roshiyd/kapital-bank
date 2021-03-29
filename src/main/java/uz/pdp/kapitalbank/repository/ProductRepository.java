package uz.pdp.kapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.kapitalbank.entity.Customer;
import uz.pdp.kapitalbank.entity.Payment;
import uz.pdp.kapitalbank.entity.Product;
import uz.pdp.kapitalbank.projection.CustomProduct;

@RepositoryRestResource(path = "product",collectionResourceRel = "list",excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
