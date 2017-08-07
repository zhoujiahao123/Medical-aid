package com.example;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass {
    public static void main(String []args)throws Exception{
        Schema schema = new Schema(1,"com.zxr.medicalaid");
        addUser(schema);
        addDate(schema);
        addMedicalList(schema);
        addMedicalDate(schema);
        new DaoGenerator().generateAll(schema,"app/src/main/java-gen");
    }
    public static void addUser(Schema schema){
        Entity user = schema.addEntity("User");
        user.addIdProperty().primaryKey();
        user.addStringProperty("idString");
        user.addStringProperty("uName");
        user.addStringProperty("phoneNumber");
        user.addStringProperty("password");
        user.addStringProperty("type");
        user.addIntProperty("isAlready");
    }
    public static void addMedicalList(Schema schema){
        Entity list = schema.addEntity("MedicalList");
        list.addStringProperty("date");
        list.addStringProperty("name");
        list.addStringProperty("weight");
        list.addStringProperty("patient");
    }
    public static void addDate(Schema schema){
        Entity date = schema.addEntity("Date");
        date.addStringProperty("date");
    }
    public static void addMedicalDate(Schema schema){
        Entity medicalDate = schema.addEntity("MedicalDateInfo");
        medicalDate.addIdProperty();
        medicalDate.addIntProperty("drawerNum");
        medicalDate.addStringProperty("name");
        medicalDate.addStringProperty("productDate");
        medicalDate.addStringProperty("shelfLife");
    }
}
