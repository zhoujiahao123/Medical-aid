package com.zxr.medicalaid.mvp.entity.moudle;

/**
 * Created by ASUS-NB on 2017/7/4.
 */

public class DrugInfo {


    /**
     * chineseName : 中文
     * englishName : 英文
     * category : 类属
     * imagePath : 图片
     * introduction : 介绍
     * growthHabit : 生长环境
     * medicinalValue : 药用价值
     * character : 生长特性
     */

    private String chineseName;
    private String englishName;
    private String category;
    private String imagePath;
    private String introduction;
    private String growthHabit;
    private String medicinalValue;
    private String character;

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getGrowthHabit() {
        return growthHabit;
    }

    public void setGrowthHabit(String growthHabit) {
        this.growthHabit = growthHabit;
    }

    public String getMedicinalValue() {
        return medicinalValue;
    }

    public void setMedicinalValue(String medicinalValue) {
        this.medicinalValue = medicinalValue;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
