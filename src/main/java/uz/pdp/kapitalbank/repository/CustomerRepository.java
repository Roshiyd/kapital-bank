package uz.pdp.kapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.kapitalbank.entity.Category;
import uz.pdp.kapitalbank.entity.Customer;
import uz.pdp.kapitalbank.projection.CustomCustomer;

import java.util.List;

@RepositoryRestResource(path = "customer",collectionResourceRel = "list",excerptProjection = CustomCustomer.class)
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select cs.id,cs.name,cs.address,cs.country,cs.phone from orders o join customer cs on o.customer_id=cs.id \n" +
            "where o.date not between '2016-01-01' and '2016-12-31'",nativeQuery = true)
    List<?> customersWithoutOrders();

    @Query(value = "select cs.id,cs.name,max(o.date) as recent from orders o join customer cs on o.customer_id=cs.id \n" +
            "group by 1",nativeQuery = true)
    List<?> customersLastOrders();
}
