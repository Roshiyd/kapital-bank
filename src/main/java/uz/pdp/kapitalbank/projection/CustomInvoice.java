package uz.pdp.kapitalbank.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.kapitalbank.entity.Invoice;
import uz.pdp.kapitalbank.entity.Order;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.sql.Date;

@Projection(types = Invoice.class)
public interface CustomInvoice {
    Integer getId();

    Order getOrder();

    Double getAmount();

    Date getIssued();

    Date getDue();
}
