package uz.pdp.kapitalbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import uz.pdp.kapitalbank.entity.Invoice;
import uz.pdp.kapitalbank.entity.Order;
import uz.pdp.kapitalbank.repository.CustomerRepository;
import uz.pdp.kapitalbank.repository.DetailRepository;
import uz.pdp.kapitalbank.repository.InvoiceRepository;
import uz.pdp.kapitalbank.repository.OrderRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DetailRepository detailRepository;


    public List<Invoice> expiredInvoices(){
        List<Invoice> afterDueDate = invoiceRepository.issuedAfterDueDate();
        return afterDueDate;
    }

    public List<?> wrongDateInvoices(){
        List<?> objects = invoiceRepository.issuedBefore();
        return objects;
    }

    public List<Order> ordersWithoutDetails(){
        List<Order> ordersWithoutDetails = orderRepository.ordersWithoutDetails();
        return ordersWithoutDetails;
    }

    public List<?> customersWithoutOrders(){
        List<?> customersWithoutOrders = customerRepository.customersWithoutOrders();
        return customersWithoutOrders;
    }

    public List<?> customersLastOrders(){
        List<?> customersLastOrders = customerRepository.customersLastOrders();
        return customersLastOrders;
    }
    public List<?> overpaidInvoices(){
        List<?> overpaidInvoices = invoiceRepository.overpaidInvoices();
        return overpaidInvoices;
    }
    public List<?> highDemandProducts(){
        List<?> highDemandProducts = detailRepository.highDemandProducts();
        return highDemandProducts;
    }


    public List<?> bulkProducts(){
        List<?> bulkProducts = detailRepository.bulkProducts();
        return bulkProducts;
    }

    public List<?> numberOfProductsInYear(){
        List<?> numberOfProductsInYear = orderRepository.numberOfProductsInYear();
        return numberOfProductsInYear;
    }


    public List<?> ordersWithoutInvoices(){
        List<?> ordersWithoutInvoices = orderRepository.ordersWithoutInvoices();
        return ordersWithoutInvoices;
    }

}
