package org.example.electricitybill.Repository;

import org.example.electricitybill.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("SELECT p FROM Payment p WHERE p.customer.id = :customerId " +
            "AND p.paymentDate BETWEEN :startDate AND :endDate")
    List<Payment> findByCustomerAndDateRange(
            @Param("customerId") int customerId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}