package com.adibu.training.jnds_demo.controller;

import com.adibu.training.jnds_demo.service.ProdukService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adibu.training.jnds_demo.model.ProdukModel;

@RestController
@RequestMapping("/produk")
public class ProdukController {

    @Autowired
    ProdukService service = new ProdukService();

    @PostMapping("/getProduk")
    public String getAllProduk() {
        return service.getAllProduk();
    }

    @PostMapping("/getProdukById")
    public String getProdukById(@RequestBody ProdukModel model) {
        return service.getProdukById(model);
    }

    @PostMapping("/getProdukByName")
    public String getProdukByName(@RequestBody ProdukModel model) {
        return service.getProdukByName(model);
    }

    @PostMapping("/insertProduk")
    public String insertProduk(@RequestBody ProdukModel model) {
        return service.insertProduk(model);
    }

    @PostMapping("/updateProdukById")
    public String updateProdukById(@RequestBody ProdukModel model) {
        return service.updateProdukById(model);
    }

    @PostMapping("/deleteProdukById")
    public String deleteProduk(@RequestBody ProdukModel model) {
        return service.deleteProdukById(model);
    }
}
