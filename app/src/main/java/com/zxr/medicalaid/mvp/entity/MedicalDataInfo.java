package com.zxr.medicalaid.mvp.entity;

/**
 * Created by 张兴锐 on 2017/8/7.
 */

public class MedicalDataInfo {
    private String name;
    private String ShelfLife;
    private String productDate;
    private int drawerNum;

    public MedicalDataInfo(String name, String shelfLife, String productDate, int drawerNum) {
        this.name = name;
        ShelfLife = shelfLife;
        this.productDate = productDate;
        this.drawerNum = drawerNum;
    }

    public int getDrawerNum() {
        return drawerNum;
    }

    public void setDrawerNum(int drawerNum) {
        this.drawerNum = drawerNum;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String getShelfLife() {
        return ShelfLife;
    }

    public void setShelfLife(String shelfLife) {
        ShelfLife = shelfLife;
    }
}
