package com.asa.dem.spring.boot.vwe;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:36 2019/10/25.
 */
public class VweCodeGenerator {
    private static String DATASOURCE_URL = "jdbc:mysql://127.0.0.1:3306/spring_boot?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    private static String PATH_SEPARATOR = "/";
    private static String PARENT_PACKAGE = "com.asa.dem.spring.boot";
    private static String ENTITY_SUFFIX = "Model";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String userDir = System.getProperty("user.dir");
        String projectPath = userDir + "/spring-boot-data" + "/spring-data-mybatis-plus-mysql";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("asa.x");
        gc.setActiveRecord(false);

        gc.setEntityName("%s" + ENTITY_SUFFIX);
        gc.setMapperName("%sDao");
        gc.setActiveRecord(false);
        gc.setBaseResultMap(true);
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DATASOURCE_URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("vwe");
        pc.setParent(PARENT_PACKAGE);
        pc.setEntity("model");
        pc.setMapper("dao");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("supperEntityCardArg", "Long");
                map.put("hasSuperEntityCard", Boolean.TRUE);
                this.setMap(map);
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        //mapper.xml
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + PATH_SEPARATOR + tableInfo.getEntityName().replace(ENTITY_SUFFIX, "ExtMapper")
                        + StringPool.DOT_XML;
            }
        });
        //model
        focList.add(new FileOutConfig("/template/vwe-entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return userDir + "/spring-boot-domain/spring-boot-domain-model"
                        + "/src/main/java/"
                        + PARENT_PACKAGE.replaceAll("\\.", "/")
                        + PATH_SEPARATOR
                        + pc.getModuleName()
                        + "/model"
                        + PATH_SEPARATOR + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });

        focList.add(new FileOutConfig("/template/vwe-mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/"
                        + PARENT_PACKAGE.replaceAll("\\.", "/")
                        + PATH_SEPARATOR
                        + pc.getModuleName()
                        + "/dao"
                        + PATH_SEPARATOR + tableInfo.getEntityName().replace("Model", "Dao")
                        + StringPool.DOT_JAVA;
            }
        });

        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null)
                .setEntity(null)
                .setMapper(null)
                .setServiceImpl(null)
                .setService(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.asa.dem.spring.boot.common.BaseModel");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass("com.asa.dem.spring.boot.vwe.controller.BaseController");
        strategy.setSuperServiceImplClass("com.asa.dem.spring.boot.vwe.service.impl.BaseService");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id", "creator", "createTime", "modifier", "modifyTime");
        strategy.setInclude("^vwe_(.*)$", "user", "session", "test");   //
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}