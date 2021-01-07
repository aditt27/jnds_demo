package com.adibu.training.jnds_demo.entity;

import java.sql.Timestamp;

//@Entity
//@Table(name = "ms_produk_gadai")
public class ProdukEntity {

    public static String TABLE_NAME = "ms_produk_gadai";

    //@Id
    //@Column(name = "produk_id", nullable = false, length = 15)
    public static String PRODUK_ID_COLUMN = "produk_id";
    private String produkId;

    //@Column(name = "produk_name", nullable = false, length = 30)
    private String produkName;

    //@Column(name = "produk_desc")
    private String produkDesc;

    //@Column(name = "ltv", length = 5, scale = 2)
    private Double ltv;

    //@Column(name = "jangka_waktu", length = 3)
    private Integer jangkaWaktu;

    //@Column(name = "tipe_admin_buka", length = 10)
    private String tipeAdminBuka;

    //@Column(name = "biaya_admin_buka", length = 17, scale = 2)
    private Double biayaAdminBuka;

    //@Column(name = "tipe_admin_tutup", length = 10)
    private String tipeAdminTutup;

    //@Column(name = "biaya_admin_tutup", length = 17, scale = 2)
    private Double biayaAdminTutup;

    //@Column(name = "biaya_jasa_penyimpanan", length = 5, scale = 2)
    private Double biayaJasaPenyimpanan;

    //@Column(name = "periode_jasa_penyimpanan", length = 5, scale = 2)
    private Double periodeJasaPenyimpanan;

    //@Column(name = "biaya_keterlambatan", length = 5, scale = 2)
    private Double biayaKeterlambatan;

    //@Column(name = "periode_biaya_keterlambatan", length = 5, scale = 2)
    private Double periodeBiayaKeterlambatan;

    //@Column(name = "created_date", nullable = false)
    //@CreationTimestamp
    private Timestamp createdDate;

    //@Column(name = "created_by", nullable = false, length = 15)
    private String createdBy;

    //@Column(name = "updated_date")
    private Timestamp updatedDate;

    //@Column(name = "updated_by", length = 15)
    private String updatedBy;

    //@Column(name = "deleted_date")
    private Timestamp deletedDate;

    //@Column(name = "deleted_by", length = 15)
    private String deletedBy;

    //@Column(name = "rec_status", length = 1)
    private String recStatus;


    public String getProdukId() {
        return this.produkId;
    }

    public void setProdukId(String produkId) {
        this.produkId = produkId;
    }

    public String getProdukName() {
        return this.produkName;
    }

    public void setProdukName(String produkName) {
        this.produkName = produkName;
    }

    public String getProdukDesc() {
        return this.produkDesc;
    }

    public void setProdukDesc(String produkDesc) {
        this.produkDesc = produkDesc;
    }

    public Double getLtv() {
        return this.ltv;
    }

    public void setLtv(Double ltv) {
        this.ltv = ltv;
    }

    public Integer getJangkaWaktu() {
        return this.jangkaWaktu;
    }

    public void setJangkaWaktu(Integer jangkaWaktu) {
        this.jangkaWaktu = jangkaWaktu;
    }

    public String getTipeAdminBuka() {
        return this.tipeAdminBuka;
    }

    public void setTipeAdminBuka(String tipeAdminBuka) {
        this.tipeAdminBuka = tipeAdminBuka;
    }

    public Double getBiayaAdminBuka() {
        return this.biayaAdminBuka;
    }

    public void setBiayaAdminBuka(Double biayaAdminBuka) {
        this.biayaAdminBuka = biayaAdminBuka;
    }

    public String getTipeAdminTutup() {
        return this.tipeAdminTutup;
    }

    public void setTipeAdminTutup(String tipeAdminTutup) {
        this.tipeAdminTutup = tipeAdminTutup;
    }

    public Double getBiayaAdminTutup() {
        return this.biayaAdminTutup;
    }

    public void setBiayaAdminTutup(Double biayaAdminTutup) {
        this.biayaAdminTutup = biayaAdminTutup;
    }

    public Double getBiayaJasaPenyimpanan() {
        return this.biayaJasaPenyimpanan;
    }

    public void setBiayaJasaPenyimpanan(Double biayaJasaPenyimpanan) {
        this.biayaJasaPenyimpanan = biayaJasaPenyimpanan;
    }

    public Double getPeriodeJasaPenyimpanan() {
        return this.periodeJasaPenyimpanan;
    }

    public void setPeriodeJasaPenyimpanan(Double periodeJasaPenyimpanan) {
        this.periodeJasaPenyimpanan = periodeJasaPenyimpanan;
    }

    public Double getBiayaKeterlambatan() {
        return this.biayaKeterlambatan;
    }

    public void setBiayaKeterlambatan(Double biayaKeterlambatan) {
        this.biayaKeterlambatan = biayaKeterlambatan;
    }

    public Double getPeriodeBiayaKeterlambatan() {
        return this.periodeBiayaKeterlambatan;
    }

    public void setPeriodeBiayaKeterlambatan(Double periodeBiayaKeterlambatan) {
        this.periodeBiayaKeterlambatan = periodeBiayaKeterlambatan;
    }

    public Timestamp getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getDeletedDate() {
        return this.deletedDate;
    }

    public void setDeletedDate(Timestamp deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return this.deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getRecStatus() {
        return this.recStatus;
    }

    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }


}
