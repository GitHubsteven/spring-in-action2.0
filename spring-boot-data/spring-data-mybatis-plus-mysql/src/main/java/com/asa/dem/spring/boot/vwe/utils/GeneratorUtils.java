/**
 * @author: asx
 * @date: 2022/11/30
 * @descrition:
 */
package com.asa.dem.spring.boot.vwe.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class GeneratorUtils {
    private static String DATASOURCE_URL = "jdbc:mysql://127.0.0.1:3306/asx?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    private static String PATH_SEPARATOR = "/";
    private static String PARENT_PACKAGE = "com.asa.dem.spring.boot";
    private static String ENTITY_SUFFIX = "Model";

    public static void main(String[] args) {
        FastAutoGenerator.create(DATASOURCE_URL, "root", "root")
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("F:\\work_place1\\spring-in-action2.0\\spring-boot-data\\spring-data-mybatis-plus-mysql"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("student") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
