package com.adibu.training.jnds_demo.service;

import com.adibu.training.jnds_demo.repository.ProdukRepository;
import com.adibu.training.jnds_demo.constant.GlobalConstant;
import com.adibu.training.jnds_demo.entity.ProdukEntity;
import com.adibu.training.jnds_demo.model.ProdukModel;
import com.adibu.training.jnds_demo.model.ResponseModel;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;

@Service
public class ProdukService {

    public String getAllProduk() {
        ArrayList<ProdukEntity> allProduk = ProdukRepository.findAll();
        return GlobalConstant.gson.toJson(allProduk);
    }

    public String getProdukById(ProdukModel model) {
        ProdukEntity produk = ProdukRepository.findById(model.getProdukId());
        if(produk.getProdukId()!=null) {
            return GlobalConstant.gson.toJson(produk);
        } else {
            ResponseModel response = new ResponseModel();
            response.setMessage("Produk Not Found");
            return GlobalConstant.gson.toJson(response);
        }
    }

    public String getProdukByName(ProdukModel model) {
        ArrayList<ProdukEntity> produk = ProdukRepository.findByName(model.getProdukName());
        return GlobalConstant.gson.toJson(produk);
    }

    public String insertProduk(ProdukModel model) {
        ResponseModel response = new ResponseModel();
        if(model.getProdukId()!=null && model.getProdukName()!=null && model.getCreatedBy()!=null) {
            ProdukEntity produk = new ProdukEntity();

            if(model.getProdukId()!=null) produk.setProdukId(model.getProdukId());
            if(model.getProdukName()!=null) produk.setProdukName(model.getProdukName());
            if(model.getProdukDesc()!=null) produk.setProdukDesc(model.getProdukDesc());
            if(model.getLtv()!=null) produk.setLtv(model.getLtv());
            if(model.getJangkaWaktu()!=null) produk.setJangkaWaktu(model.getJangkaWaktu());
            if(model.getTipeAdminBuka()!=null) produk.setTipeAdminBuka(model.getTipeAdminBuka());
            if(model.getBiayaAdminBuka()!=null) produk.setTipeAdminBuka(model.getTipeAdminBuka());
            if(model.getTipeAdminTutup()!=null) produk.setTipeAdminTutup(model.getTipeAdminTutup());
            if(model.getBiayaAdminTutup()!=null) produk.setBiayaAdminTutup(model.getBiayaAdminTutup());
            if(model.getBiayaJasaPenyimpanan()!=null) produk.setBiayaJasaPenyimpanan(model.getBiayaJasaPenyimpanan());
            if(model.getPeriodeJasaPenyimpanan()!=null) produk.setPeriodeJasaPenyimpanan(model.getPeriodeJasaPenyimpanan());
            if(model.getBiayaKeterlambatan()!=null) produk.setBiayaKeterlambatan(model.getBiayaKeterlambatan());
            if(model.getPeriodeBiayaKeterlambatan()!=null) produk.setPeriodeBiayaKeterlambatan(model.getPeriodeBiayaKeterlambatan());
            if(model.getCreatedBy()!=null) produk.setCreatedBy(model.getCreatedBy());
            if(model.getUpdatedBy()!=null) produk.setUpdatedBy(model.getUpdatedBy());
            if(model.getDeletedBy()!=null) produk.setDeletedBy(model.getDeletedBy());
            if(model.getRecStatus()!=null) produk.setRecStatus(model.getRecStatus());

            try{
                if(model.getCreatedDate()!=null) {
                    Date parsedDate = GlobalConstant.dateTimeFormat.parse(model.getCreatedDate());
                    produk.setCreatedDate(new Timestamp(parsedDate.getTime()));
                }
                if(model.getUpdatedDate()!=null) {
                    Date parsedDate = GlobalConstant.dateTimeFormat.parse(model.getUpdatedDate());
                    produk.setUpdatedDate(new Timestamp(parsedDate.getTime()));
                }
                if(model.getDeletedDate()!=null) {
                    Date parsedDate = GlobalConstant.dateTimeFormat.parse(model.getDeletedDate());
                    produk.setUpdatedDate(new Timestamp(parsedDate.getTime()));
                }
            } catch(Exception e) {
                response.setMessage("Date Syntax Error");
                return GlobalConstant.gson.toJson(response);
            }

            ProdukEntity produkSaved = ProdukRepository.insert(produk);
            return GlobalConstant.gson.toJson(produkSaved);
        } else {
            response.setMessage("Missing Required Field");
            return GlobalConstant.gson.toJson(response);
        }
    }

    public String updateProdukById(ProdukModel model) {
        ResponseModel response = new ResponseModel();
        if(model.getProdukId()!=null) {
            ProdukEntity produk = ProdukRepository.findById(model.getProdukId());
            if(produk.getProdukId()!=null) {

                if(model.getProdukName()!=null) produk.setProdukName(model.getProdukName());
                if(model.getProdukDesc()!=null) produk.setProdukDesc(model.getProdukDesc());
                if(model.getLtv()!=null) produk.setLtv(model.getLtv());
                if(model.getJangkaWaktu()!=null) produk.setJangkaWaktu(model.getJangkaWaktu());
                if(model.getTipeAdminBuka()!=null) produk.setTipeAdminBuka(model.getTipeAdminBuka());
                if(model.getBiayaAdminBuka()!=null) produk.setTipeAdminBuka(model.getTipeAdminBuka());
                if(model.getTipeAdminTutup()!=null) produk.setTipeAdminTutup(model.getTipeAdminTutup());
                if(model.getBiayaAdminTutup()!=null) produk.setBiayaAdminTutup(model.getBiayaAdminTutup());
                if(model.getBiayaJasaPenyimpanan()!=null) produk.setBiayaJasaPenyimpanan(model.getBiayaJasaPenyimpanan());
                if(model.getPeriodeJasaPenyimpanan()!=null) produk.setPeriodeJasaPenyimpanan(model.getPeriodeJasaPenyimpanan());
                if(model.getBiayaKeterlambatan()!=null) produk.setBiayaKeterlambatan(model.getBiayaKeterlambatan());
                if(model.getPeriodeBiayaKeterlambatan()!=null) produk.setPeriodeBiayaKeterlambatan(model.getPeriodeBiayaKeterlambatan());
                if(model.getCreatedBy()!=null) produk.setCreatedBy(model.getCreatedBy());
                if(model.getUpdatedBy()!=null) produk.setUpdatedBy(model.getUpdatedBy());
                if(model.getDeletedBy()!=null) produk.setDeletedBy(model.getDeletedBy());
                if(model.getRecStatus()!=null) produk.setRecStatus(model.getRecStatus());

                try{
                    if(model.getCreatedDate()!=null) {
                        Date parsedDate = GlobalConstant.dateTimeFormat.parse(model.getCreatedDate());
                        produk.setCreatedDate(new Timestamp(parsedDate.getTime()));
                    }
                    if(model.getUpdatedDate()!=null) {
                        Date parsedDate = GlobalConstant.dateTimeFormat.parse(model.getUpdatedDate());
                        produk.setUpdatedDate(new Timestamp(parsedDate.getTime()));
                    }
                    if(model.getDeletedDate()!=null) {
                        Date parsedDate = GlobalConstant.dateTimeFormat.parse(model.getDeletedDate());
                        produk.setUpdatedDate(new Timestamp(parsedDate.getTime()));
                    }
                } catch(Exception e) {
                    response.setMessage("Date Syntax Error");
                    e.printStackTrace();
                    return GlobalConstant.gson.toJson(response);
                }

                ProdukEntity produkSaved = ProdukRepository.updateById(produk);
                return GlobalConstant.gson.toJson(produkSaved);

            } else {
                response.setMessage("Produk Id Not Found");
                return GlobalConstant.gson.toJson(response);
            }
        } else {
            response.setMessage("Missing Produk Id Field");
            return GlobalConstant.gson.toJson(response);
        }
    }

    public String deleteProdukById(ProdukModel model) {
        ResponseModel response = new ResponseModel();
        ProdukRepository.deleteById(model.getProdukId());
        response.setMessage("Delete Produk With Id: " + model.getProdukId());
        return GlobalConstant.gson.toJson(response);
    }
}
