package uz.pdp.kapitalbank.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.kapitalbank.entity.Invoice;
import uz.pdp.kapitalbank.entity.Payment;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Projection(types = Payment.class)
public interface CustomPayment {
    Integer getId();

    Timestamp getTime();

    Double getAmount();

    Invoice getInvoice();
}
