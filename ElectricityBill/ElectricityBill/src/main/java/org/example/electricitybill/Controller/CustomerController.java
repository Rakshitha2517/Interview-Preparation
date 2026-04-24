package org.example.electricitybill.Controller;

import org.example.electricitybill.Entity.Customer;
import org.example.electricitybill.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController        
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;
//display customer
    @GetMapping
    public List<Customer> getCustomer() {
        return service.getAllCustomer();
    }
//add customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer c) {
        return service.saveCustomer(c);
    }
//update customer details
    @PutMapping("/{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer c) {
        return service.updateCustomer(id, c);
    }
//delete customer
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteCustomer(id);
    }
}
