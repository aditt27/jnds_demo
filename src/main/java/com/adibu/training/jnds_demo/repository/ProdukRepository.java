package com.adibu.training.jnds_demo.repository;

import java.util.ArrayList;
import java.util.Properties;

import com.adibu.training.jnds_demo.entity.ProdukEntity;

import id.co.nds.dbaccess.connection.DBConnection;
import id.co.nds.dbaccess.sqlcustom.SQLCustomStatement;
import id.co.nds.dbaccess.sqlstandard.SQLStandard;

public class ProdukRepository{

    public static ProdukEntity insert(ProdukEntity produk) {
        DBConnection dbconn = null;
        SQLStandard sql = null;
        ProdukEntity result = new ProdukEntity();

        try{
            dbconn = new DBConnection();
            sql = new SQLStandard(dbconn);

            Integer sqlResult = sql.executeInsert(ProdukEntity.TABLE_NAME, produk);
            if(sqlResult==1) {
                result = produk;
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(sql!=null) sql.close();
            if(dbconn!=null) dbconn.close();
        }
        return result;
    }

    public static ArrayList<ProdukEntity> findAll() {
        DBConnection dbconn = null;
        SQLStandard sql = null;
        ArrayList<ProdukEntity> hasil = new ArrayList<>();
        try{
            dbconn = new DBConnection();
            sql = new SQLStandard(dbconn);

            ArrayList<String> fields = new ArrayList<>();
            fields.add("*");
            hasil = sql.executeQueryList(ProdukEntity.TABLE_NAME, fields, null, null, ProdukEntity.class);
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(sql!=null) sql.close();
            if(dbconn!=null) dbconn.close();
        }
        return hasil;
    }

    public static ProdukEntity findById(String id) {
        DBConnection dbconn = null;
        SQLStandard sql = null;
        ProdukEntity hasil = new ProdukEntity();
        try{
            dbconn = new DBConnection();
            sql = new SQLStandard(dbconn);

            ArrayList<String> fields = new ArrayList<>();
            fields.add("*");
            Properties criterias = new Properties();
            criterias.put(ProdukEntity.PRODUK_ID_COLUMN, "= " + "'" + id + "'");
            ArrayList<ProdukEntity> arList = sql.executeQueryList(ProdukEntity.TABLE_NAME, fields, criterias, null, ProdukEntity.class);
            hasil = arList.get(0);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(sql!=null) sql.close();
            if(dbconn!=null) dbconn.close();
        }
        return hasil;
    }

    public static ArrayList<ProdukEntity> findByName(String produkName) {
        DBConnection dbconn = null;
        SQLCustomStatement sqlc = null;
        ArrayList<ProdukEntity> hasil = new ArrayList<>();
        try{
            dbconn = new DBConnection();
            sqlc = new SQLCustomStatement(dbconn);

            Properties param = new Properties();
            param.put("criteria", "'%" + produkName + "%'");
            hasil = sqlc.executeQueryList("sql-produk", "queryProdukCustom", param, ProdukEntity.class);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(sqlc!=null) sqlc.close();
            if(dbconn!=null) dbconn.close();
        }
        return hasil;
    }

    public static ProdukEntity updateById(ProdukEntity produk) {
        DBConnection dbconn = null;
        SQLStandard sql = null;
        ProdukEntity result = new ProdukEntity();

        try{
            dbconn = new DBConnection();
            sql = new SQLStandard(dbconn);

            Properties criterias = new Properties();
            criterias.put(ProdukEntity.PRODUK_ID_COLUMN, "= " + "'" + produk.getProdukId() + "'");
            Integer sqlResult = sql.executeUpdate(ProdukEntity.TABLE_NAME, produk, criterias, ProdukEntity.class);
            if(sqlResult==1) {
                result = produk;
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(sql!=null) sql.close();
            if(dbconn!=null) dbconn.close();
        }
        return result;
    }

    public static Integer deleteById(String id) {
        DBConnection dbconn = null;
        SQLStandard sql = null;
        Integer result = null;

        try{
            dbconn = new DBConnection();
            sql = new SQLStandard(dbconn);

            Properties criterias = new Properties();
            criterias.put(ProdukEntity.PRODUK_ID_COLUMN, "= " + "'" + id + "'");
            result = sql.executeDelete(ProdukEntity.TABLE_NAME, criterias);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(sql!=null) sql.close();
            if(dbconn!=null) dbconn.close();
        }
        return result;
    }


}
