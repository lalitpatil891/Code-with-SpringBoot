package com.teashop.controller;

import com.teashop.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillingController {

    @Autowired
    private TeaService teaService;

    @GetMapping
    public String getBill(@RequestParam String teaType, @RequestParam int quantity) {
        double total = teaService.calculateBill(teaType, quantity);

        return "Total bill for " + quantity + " " + teaType + " tea: rs "+total;
    }

}
