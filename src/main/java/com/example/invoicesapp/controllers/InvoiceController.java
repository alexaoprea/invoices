package com.example.invoicesapp.controllers;

import com.example.invoicesapp.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/invoice")
    public void addInvoice(@RequestBody Invoice invoice){
        String sql = "INSERT INTO invoice VALUES (NULL,?,?,?,?)";
        jdbcTemplate.update(sql,
                invoice.getNr(),
                invoice.getSerie(),
                invoice.getFirma(),
                invoice.getDescriere()
        );
    }
}
