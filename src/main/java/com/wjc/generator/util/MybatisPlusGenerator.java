package com.wjc.generator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;

public class MybatisPlusGenerator {
    public static void main(String[] args) {

        List<String> tables = new ArrayList<>();
        tables.add("BASIC_XCURR");
//        tables.add("BASIC_XBAIK");
//        tables.add("BASIC_XCUST");
//        tables.add("BASIC_XHEAD");
//        tables.add("BASIC_XITEM");
//        tables.add("BASIC_XPRTS");
//        tables.add("BASIC_XSECT");
//        tables.add("BASIC_XTANK");

        FastAutoGenerator.create("jdbc:sqlserver://localhost:1433;databaseName=BNWMS", "sa", "123")
                .globalConfig(builder -> {
                    builder.author("wjc")               //作者
                            .outputDir(System.getProperty("user.dir")+"\\src\\main\\java")    //输出路径(写到java目录)
                            .enableSwagger()           //开启swagger
                            .commentDate("yyyy-MM-dd")
                            .fileOverride()            //开启覆盖之前生成的文件
                            .disableOpenDir();         //禁止打开文件目录


                })
                .packageConfig(builder -> {
                    builder.parent("com.wms.basic")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,System.getProperty("user.dir")+"\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();  //开启lombok表达式addInclude(tables) //添加表名
                    builder.mapperBuilder().enableBaseResultMap().enableMapperAnnotation(); //生成resultMap，生成mapper注解
                    builder.addInclude(tables).addTablePrefix("BASIC_X"); //添加表，过滤表名前缀
                })
                //.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateConfig(builder -> {
                    builder.controller("\\templates\\controller.java.vm")
                            .service("\\templates\\service.java.vm")
                            .serviceImpl("\\templates\\serviceImpl.java.vm")
                            .mapper("\\templates\\mapper.java.vm")
                            .entity("\\templates\\entity.java.vm")
                            .mapperXml("\\templates\\mapper.xml.vm");
                })
                .execute();
    }
}
