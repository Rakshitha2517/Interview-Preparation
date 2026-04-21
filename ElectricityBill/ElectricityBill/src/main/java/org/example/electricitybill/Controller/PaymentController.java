package org.example.electricitybill.Controller;

import org.example.electricitybill.Entity.Payment;
import org.example.electricitybill.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping("/payment")
    public List<Payment> getPayment() {
        return service.getAllPayments();
    }

    @PostMapping("/payment")
    public Payment addPayment(@RequestBody Payment p) {
        return service.savePayment(p);
    }

    @PutMapping("/payment/{id}")
    public Payment update(@PathVariable int id, @RequestBody Payment p) {
        return service.updatePayment(id, p);
    }

    @DeleteMapping("/payment/{id}")
    public String delete(@PathVariable int id) {
        return service.deletePayment(id);
    }
}