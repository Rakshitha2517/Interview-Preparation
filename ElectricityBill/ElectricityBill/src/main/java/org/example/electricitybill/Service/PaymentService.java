package org.example.electricitybill.Service;

import org.example.electricitybill.Entity.Payment;
import org.example.electricitybill.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    @Autowired
    private BillCalculatorService billCalculatorService;

    public Payment savePayment(Payment p) {
        double units = p.getUnitsConsumed();
        
        p.setAmount(billCalculatorService.calculateBill(units));
        p.setSlabCategory(billCalculatorService.getSlabCategory(units));
        p.setPaymentDate(LocalDate.now());

        return repo.save(p);
    }

    public List<Payment> getAllPayments() {
        return repo.findAll();
    }

    public String deletePayment(int id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    public Payment updatePayment(int id, Payment p) {
        Payment existing = repo.findById(id).orElse(null);

        if (existing != null) {
            double units = p.getUnitsConsumed();
            existing.setCustomer(p.getCustomer());
            existing.setUnitsConsumed(units);
            existing.setAmount(billCalculatorService.calculateBill(units));
            existing.setSlabCategory(billCalculatorService.getSlabCategory(units));
            existing.setPaymentType(p.getPaymentType());
            return repo.save(existing);
        }

        return null;
    }

    public List<Payment> getOneYearHistory(int customerId) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusYears(1);
        return repo.findByCustomerAndDateRange(customerId, startDate, endDate);
    }
}