package com.teashop.service;

import org.springframework.stereotype.Service;

@Service
public class TeaService {

    public double calculateBill(String teaType, int quantity) {
        double price = switch (teaType.toLowerCase()) {
            case "masala" -> 12.0;
            case "ginger" -> 10.0;
            case "black" -> 8.0;
            default -> 9.0;
        };
        return price * quantity;

    }
}
