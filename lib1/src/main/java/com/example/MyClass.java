package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Schema;

public class MyClass {
    public static void main(String[] args) throws Exception {
        Schema schema=new Schema(1,"com.example.greendao");

        //自动生成代码并且给予生成代码的路径
        new DaoGenerator().generateAll(schema,"app/src/main/java-gen");
    }
}
