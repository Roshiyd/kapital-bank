package uz.pdp.kapitalbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.kapitalbank.entity.Invoice;
import uz.pdp.kapitalbank.entity.Order;
import uz.pdp.kapitalbank.service.Service;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    Service service;

    //Invoices issued after their due time
    @GetMapping("api/invoice/expiredInvoices")
    public ResponseEntity<List<Invoice>> expiredInvoices() {
        List<Invoice> invoiceList = service.expiredInvoices();
        return ResponseEntity.ok(invoiceList);
    }

    //Invoices that were issued before the date in which the order they refer to was placed.
    @GetMapping("api/invoice/wrongDateInvoices")
    public ResponseEntity<List<?>> wrongDateInvoices() {
        List<?> issuedBeforeAndOrder = service.wrongDateInvoices();
        return ResponseEntity.ok(issuedBeforeAndOrder);
    }

    //Orders that do not have a detail and were placed before 6 September 2016.
    @GetMapping("api/order/ordersWithoutDetails")
    public ResponseEntity<List<Order>> ordersWithoutDetails() {
        List<Order> ordersWithoutDetails = service.ordersWithoutDetails();
        return ResponseEntity.ok(ordersWithoutDetails);
    }

    //Orders that do not have a detail and were placed before 6 September 2016.
    @GetMapping("api/customer/customersWithoutOrders")
    public ResponseEntity<List<?>> customersWithoutOrders() {
        List<?> customersWithoutOrders = service.customersWithoutOrders();
        return ResponseEntity.ok(customersWithoutOrders);
    }

    //Orders that do not have a detail and were placed before 6 September 2016.
    @GetMapping("api/customer/customersLastOrders")
    public ResponseEntity<List<?>> customersLastOrders() {
        List<?> customersLastOrders = service.customersLastOrders();
        return ResponseEntity.ok(customersLastOrders);
    }

    //Invoices that have been overpaid
    @GetMapping("api/invoice/overpaidInvoices")
    public ResponseEntity<List<?>> overpaidInvoices() {
        List<?> overpaidInvoices = service.overpaidInvoices();
        return ResponseEntity.ok(overpaidInvoices);
    }

    //Products that were ordered more than 10 times in total, by taking into account the
    //quantities in which they appear in the order details.
    @GetMapping("api/detail/highDemandProducts")
    public ResponseEntity<List<?>> highDemandProducts() {
        List<?> highDemandProducts = service.highDemandProducts();
        return ResponseEntity.ok(highDemandProducts);
    }

    //Products that are usually ordered in bulk: whenever one of these products is ordered, it
    //is ordered in a quantity that on average is equal to or greater than 8.
    @GetMapping("api/detail/bulkProducts")
    public ResponseEntity<List<?>> bulkProducts() {
        List<?> bulkProducts = service.bulkProducts();
        return ResponseEntity.ok(bulkProducts);
    }

    //9.	Total number of orders placed in 2016 by customers of each country. If all customers
    //from a specific country did not place any orders in 2016, the country will not appear in
    //the output
    @GetMapping("api/order/numberOfProductsInYear")
    public ResponseEntity<List<?>> numberOfProductsInYear() {
        List<?> numberOfProductsInYear = service.numberOfProductsInYear();
        return ResponseEntity.ok(numberOfProductsInYear);
    }
    
    //10.	For each order without invoice, list its ID, the date it was placed and the total price of the
    //products in its detail, taking into account the quantity of each ordered product and its unit
    //price. Orders without detail must not be included in the answers.
    @GetMapping("api/order/ordersWithoutInvoice")
    public ResponseEntity<List<?>> ordersWithoutInvoice() {
        List<?> ordersWithoutInvoices = service.ordersWithoutInvoices();
        return ResponseEntity.ok(ordersWithoutInvoices);
    }


}
