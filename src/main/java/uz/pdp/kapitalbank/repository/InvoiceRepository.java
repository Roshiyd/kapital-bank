package uz.pdp.kapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.kapitalbank.entity.Customer;
import uz.pdp.kapitalbank.entity.Detail;
import uz.pdp.kapitalbank.entity.Invoice;
import uz.pdp.kapitalbank.projection.CustomInvoice;

import java.util.List;

@RepositoryRestResource(path = "invoice",collectionResourceRel = "list",excerptProjection = CustomInvoice.class)
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    @Query(value = "select * from invoice where due<issued",nativeQuery = true)
    List<Invoice> issuedAfterDueDate();

    @Query(value = "select i.id,i.issued,i.order_id,o.date from invoice i join orders o on i.order_id=o.id   where due>issued",
            nativeQuery = true)
    List<?> issuedBefore();

    @Query(value = "select i.id as invoice_id, py.amount-i.amount as reimburse from invoice i join payment py on i.id=py.invoice_id\n" +
            "where py.amount>i.amount",
            nativeQuery = true)
    List<?> overpaidInvoices();


}
