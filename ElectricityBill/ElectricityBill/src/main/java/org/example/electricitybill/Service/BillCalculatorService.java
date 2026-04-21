package org.example.electricitybill.Service;

import org.springframework.stereotype.Service;

@Service
public class BillCalculatorService {

    public double calculateBill(double units) {
        double bill = 0;

        if (units <= 100) {
            bill = units * 3.50;

        } else if (units <= 200) {
            bill = (100 * 3.50) + ((units - 100) * 5.00);

        } else if (units <= 300) {
            bill = (100 * 3.50) + (100 * 5.00) + ((units - 200) * 7.00);

        } else {
            bill = (100 * 3.50) + (100 * 5.00) + (100 * 7.00) + ((units - 300) * 9.00);
        }

        return bill;
    }

    public String getSlabCategory(double units) {
        if (units <= 100) {
            return "Slab 1: 0-100 units @ ₹3.50/unit";
        } else if (units <= 200) {
            return "Slab 2: 101-200 units @ ₹5.00/unit";
        } else if (units <= 300) {
            return "Slab 3: 201-300 units @ ₹7.00/unit";
        } else {
            return "Slab 4: 300+ units @ ₹9.00/unit";
        }
    }
}