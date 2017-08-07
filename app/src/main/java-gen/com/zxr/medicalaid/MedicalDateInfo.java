package com.zxr.medicalaid;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table MEDICAL_DATE_INFO.
 */
public class MedicalDateInfo {

    private Long id;
    private Integer drawerNum;
    private String name;
    private String productDate;
    private String shelfLife;

    public MedicalDateInfo() {
    }

    public MedicalDateInfo(Long id) {
        this.id = id;
    }

    public MedicalDateInfo(Long id, Integer drawerNum, String name, String productDate, String shelfLife) {
        this.id = id;
        this.drawerNum = drawerNum;
        this.name = name;
        this.productDate = productDate;
        this.shelfLife = shelfLife;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDrawerNum() {
        return drawerNum;
    }

    public void setDrawerNum(Integer drawerNum) {
        this.drawerNum = drawerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

}
