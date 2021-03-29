package uz.pdp.kapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.kapitalbank.entity.Attachment;
import uz.pdp.kapitalbank.entity.Customer;
import uz.pdp.kapitalbank.entity.Product;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

}
