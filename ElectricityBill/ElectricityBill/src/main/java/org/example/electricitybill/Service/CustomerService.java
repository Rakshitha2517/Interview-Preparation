package org.example.electricitybill.Service;

import org.example.electricitybill.Entity.Customer;
import org.example.electricitybill.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer saveCustomer(Customer c){
        return repo.save(c);
    }
    public List<Customer> getAllCustomer(){
        return repo.findAll();
    }

    public String deleteCustomer(int id){
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    public Customer updateCustomer(int id, Customer c){
        Customer existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setCustomerName(c.getCustomerName());
            existing.setAddress(c.getAddress());
            existing.setMeterNo(c.getMeterNo());
            return repo.save(existing);
        }

        return null;
    }
}