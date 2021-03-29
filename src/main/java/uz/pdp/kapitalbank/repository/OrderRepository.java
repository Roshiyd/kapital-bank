package uz.pdp.kapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.kapitalbank.entity.Customer;
import uz.pdp.kapitalbank.entity.Detail;
import uz.pdp.kapitalbank.entity.Order;
import uz.pdp.kapitalbank.projection.CustomOrder;

import java.util.List;

@RepositoryRestResource(path = "order",collectionResourceRel = "list",excerptProjection = CustomOrder.class)
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select * from orders where customer_id is null and date<'2016-09-06'",nativeQuery = true)
    List<Order> ordersWithoutDetails();

    @Query(value = "select count(ord.id),cs.country from orders ord join customer cs on ord.customer_id=cs.id \n" +
            "where ord.date between '2016-01-01' and '2016-12-31' \n" +
            "group by cs.country",nativeQuery = true)
    List<?> numberOfProductsInYear();



    @Query(value = "select ord.id,ord,date,sum(pr.price),pr.price from orders ord \n" +
            "join detail dt on ord.id=dt.order_id join product pr on dt.product_id=pr.id\n" +
            "where dt.order_id is not null and ord.id in \n" +
            "(select ord.id as orders_without_invoice from orders ord \n" +
            "except\n" +
            "select ord.id from orders ord join invoice i on ord.id=i.order_id where i.order_id is not null)\n" +
            "group by ord.id,pr.price",nativeQuery = true)
    List<?> ordersWithoutInvoices();


}
