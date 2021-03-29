package uz.pdp.kapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.kapitalbank.entity.Customer;
import uz.pdp.kapitalbank.entity.Detail;
import uz.pdp.kapitalbank.projection.CustomDetail;

import java.util.List;

@RepositoryRestResource(path = "detail",collectionResourceRel = "list",excerptProjection = CustomDetail.class)
public interface DetailRepository extends JpaRepository<Detail, Integer> {
    @Query(value = "select product_id, sum(quantity) from detail where order_id is not null\n" +
            "group by 1\n" +
            "having sum(quantity)>10; ",nativeQuery = true)
    List<?> highDemandProducts();

    @Query(value = "select dt.product_id,pr.price from detail dt join product pr on dt.product_id=pr.id\n" +
            "group by pr.price,dt.product_id\n" +
            "having avg(quantity)>=8;",nativeQuery = true)
    List<?> bulkProducts();

}
