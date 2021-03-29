package uz.pdp.kapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.kapitalbank.entity.Customer;
import uz.pdp.kapitalbank.entity.Order;
import uz.pdp.kapitalbank.entity.Payment;
import uz.pdp.kapitalbank.projection.CustomPayment;

@RepositoryRestResource(path = "payment",collectionResourceRel = "list",excerptProjection = CustomPayment.class)
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
